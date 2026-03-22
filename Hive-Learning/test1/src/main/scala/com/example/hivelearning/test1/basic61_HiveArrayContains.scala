package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic61_HiveArrayContains {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic61_HiveArrayContains").master("local[*]").enableHiveSupport().getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS arr_tags")
    spark.sql("CREATE TABLE arr_tags(id INT, tags ARRAY<STRING>) STORED AS PARQUET")
    spark.sql("INSERT INTO arr_tags VALUES (1, array('red','blue')), (2, array('green'))")

    spark.sql("SELECT id FROM arr_tags WHERE array_contains(tags, 'red')").show()
    spark.stop()
  }
}
