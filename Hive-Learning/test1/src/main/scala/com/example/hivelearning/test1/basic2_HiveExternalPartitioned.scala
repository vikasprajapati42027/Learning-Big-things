package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic2_HiveExternalPartitioned {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")
    val tableLocation = s"$fs/tmp/hive_test1/ext_sales"

    val spark = SparkSession.builder()
      .appName("basic2_HiveExternalPartitioned")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")

    // drop if exists for idempotency
    spark.sql("DROP TABLE IF EXISTS ext_sales")

    // create external partitioned table
    spark.sql(
      s"""CREATE EXTERNAL TABLE ext_sales(
         |  order_id STRING,
         |  amount DOUBLE
         |) PARTITIONED BY (dt STRING)
         |STORED AS PARQUET
         |LOCATION '$tableLocation'
         |""".stripMargin)

    // sample data with two partitions
    val data = Seq(
      ("o1", 10.5, "2024-01-01"),
      ("o2", 20.0, "2024-01-01"),
      ("o3", 15.0, "2024-01-02")
    )
    val df = spark.createDataFrame(data).toDF("order_id", "amount", "dt")

    df.write
      .mode("overwrite")
      .partitionBy("dt")
      .format("parquet")
      .save(tableLocation)

    // repair to load partitions
    spark.sql("MSCK REPAIR TABLE ext_sales")

    val daily = spark.sql("SELECT dt, sum(amount) as total FROM ext_sales GROUP BY dt ORDER BY dt")
    daily.show()

    spark.stop()
  }
}
