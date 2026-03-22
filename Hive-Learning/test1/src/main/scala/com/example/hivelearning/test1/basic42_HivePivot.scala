package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic42_HivePivot {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic42_HivePivot")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS pivot_sales")
    spark.sql("CREATE TABLE pivot_sales(name STRING, year STRING, sales INT) STORED AS PARQUET")
    spark.sql("INSERT INTO pivot_sales VALUES ('alice','2023',10),('alice','2024',15),('bob','2023',5)")

    spark.sql(
      """SELECT * FROM pivot_sales
        |PIVOT (sum(sales) AS total FOR year IN ('2023','2024'))""".stripMargin).show()

    spark.stop()
  }
}
