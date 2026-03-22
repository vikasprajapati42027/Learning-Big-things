package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic36_HivePartitionPruning {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")
    val loc = s"$fs/tmp/hive_test1/pp_sales"

    val spark = SparkSession.builder()
      .appName("basic36_HivePartitionPruning")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS pp_sales")
    spark.sql(
      s"""CREATE EXTERNAL TABLE pp_sales(order_id STRING, amount DOUBLE)
         |PARTITIONED BY (dt STRING)
         |STORED AS PARQUET
         |LOCATION '$loc'""".stripMargin)

    spark.sql("INSERT OVERWRITE TABLE pp_sales PARTITION(dt) VALUES ('o1', 10.0, '2024-01-01'), ('o2', 20.0, '2024-01-02')")
    spark.sql("MSCK REPAIR TABLE pp_sales")

    spark.sql("SET spark.sql.optimizer.dynamicPartitionPruning=true")
    spark.sql("EXPLAIN SELECT * FROM pp_sales WHERE dt='2024-01-01'").show(truncate = false)
    spark.stop()
  }
}
