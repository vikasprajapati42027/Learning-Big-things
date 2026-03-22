package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic10_HiveExplainFormatted {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")

    val spark = SparkSession.builder()
      .appName("basic10_HiveExplainFormatted")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS explain_people")
    spark.sql("CREATE TABLE explain_people(name STRING, age INT) STORED AS PARQUET")
    spark.sql("INSERT INTO explain_people VALUES ('alice',30), ('bob',20)")

    spark.sql("EXPLAIN FORMATTED SELECT name FROM explain_people WHERE age > 21").show(truncate = false)
    spark.stop()
  }
}
