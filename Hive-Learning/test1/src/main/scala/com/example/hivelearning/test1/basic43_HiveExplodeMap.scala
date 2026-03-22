package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic43_HiveExplodeMap {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic43_HiveExplodeMap")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS map_events")
    spark.sql("CREATE TABLE map_events(user STRING, props MAP<STRING,STRING>) STORED AS PARQUET")
    spark.sql("INSERT INTO map_events VALUES ('alice', map('os','ios','ver','1.0')), ('bob', map('os','android','ver','2.0'))")

    spark.sql(
      """SELECT user, key, value
        |FROM map_events
        |LATERAL VIEW explode(props) e as key, value""".stripMargin).show()

    spark.stop()
  }
}
