package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic34_HiveTableProperties {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")

    val spark = SparkSession.builder()
      .appName("basic34_HiveTableProperties")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS tbl_props")
    spark.sql("CREATE TABLE tbl_props(id INT) STORED AS PARQUET TBLPROPERTIES('comment'='demo table','owner'='me')")
    spark.sql("DESCRIBE EXTENDED tbl_props").show(truncate = false)
    spark.stop()
  }
}
