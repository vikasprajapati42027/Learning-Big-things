package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic6_HiveDynamicPartitionInsert {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")
    val loc = s"$fs/tmp/hive_test1/dyn_part_sales"

    val spark = SparkSession.builder()
      .appName("basic6_HiveDynamicPartitionInsert")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("SET hive.exec.dynamic.partition=true")
    spark.sql("SET hive.exec.dynamic.partition.mode=nonstrict")
    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS dyn_sales")

    spark.sql(
      s"""CREATE EXTERNAL TABLE dyn_sales(
         |  order_id STRING,
         |  amount DOUBLE
         |) PARTITIONED BY (region STRING)
         |STORED AS PARQUET
         |LOCATION '$loc'
         |""".stripMargin)

    spark.sql(
      """INSERT INTO dyn_sales PARTITION(region)
        |VALUES ('o1', 5.0, 'us'), ('o2', 7.5, 'eu'), ('o3', 9.0, 'us')
        |""".stripMargin)

    spark.sql("SHOW PARTITIONS dyn_sales").show(truncate = false)
    spark.sql("SELECT region, sum(amount) total FROM dyn_sales GROUP BY region").show()

    spark.stop()
  }
}
