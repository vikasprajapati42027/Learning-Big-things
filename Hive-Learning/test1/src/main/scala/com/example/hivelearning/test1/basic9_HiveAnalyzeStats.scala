package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic9_HiveAnalyzeStats {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")

    val spark = SparkSession.builder()
      .appName("basic9_HiveAnalyzeStats")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS stats_people")
    spark.sql("CREATE TABLE stats_people(name STRING, age INT) STORED AS PARQUET")
    spark.sql("INSERT INTO stats_people VALUES ('alice',30), ('bob',25), ('carol',40)")

    spark.sql("ANALYZE TABLE stats_people COMPUTE STATISTICS")
    spark.sql("ANALYZE TABLE stats_people COMPUTE STATISTICS FOR COLUMNS name, age")

    spark.sql("DESCRIBE EXTENDED stats_people").show(truncate = false)
    spark.stop()
  }
}
