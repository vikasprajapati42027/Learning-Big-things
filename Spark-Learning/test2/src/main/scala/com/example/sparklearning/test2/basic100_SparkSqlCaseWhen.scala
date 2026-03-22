package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic100_SparkSqlCaseWhen {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic100_SparkSqlCaseWhen").master("local[*]").getOrCreate()

    val df = spark.range(0, 6)
    val labeled = df.select(col("id"), when(col("id") % 2 === 0, "even").otherwise("odd").as("parity"))
    labeled.show()

    spark.stop()
  }
}
