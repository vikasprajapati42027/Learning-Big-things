package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic96_SparkParquetPredicatePushdown {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic96_SparkParquetPredicatePushdown").master("local[*]").getOrCreate()

    val df = spark.range(0, 100).toDF("id")
    df.write.mode("overwrite").parquet("ppd-parquet")
    spark.read.parquet("ppd-parquet").filter("id < 5").explain(true)

    spark.stop()
  }
}
