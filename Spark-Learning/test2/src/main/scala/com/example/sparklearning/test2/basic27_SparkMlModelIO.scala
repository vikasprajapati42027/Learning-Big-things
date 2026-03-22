package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic27_SparkMlModelIO {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic27_SparkMlModelIO").master("local[*]").getOrCreate()
    println("Model save/load for Pipelines needs spark-mllib classes; add the dependency to experiment.")
    spark.stop()
  }
}
