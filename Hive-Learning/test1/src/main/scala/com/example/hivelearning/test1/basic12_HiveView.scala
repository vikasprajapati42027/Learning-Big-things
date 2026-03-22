package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic12_HiveView {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")

    val spark = SparkSession.builder()
      .appName("basic12_HiveView")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS view_people")
    spark.sql("DROP VIEW IF EXISTS view_adults")
    spark.sql("CREATE TABLE view_people(name STRING, age INT) STORED AS PARQUET")
    spark.sql("INSERT INTO view_people VALUES ('alice', 30), ('bob', 17)")
    spark.sql("CREATE VIEW view_adults AS SELECT name, age FROM view_people WHERE age >= 18")

    spark.sql("SELECT * FROM view_adults").show()
    spark.stop()
  }
}
