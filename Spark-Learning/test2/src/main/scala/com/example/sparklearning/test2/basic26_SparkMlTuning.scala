package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic26_SparkMlTuning {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic26_SparkMlTuning").master("local[*]").getOrCreate()
    println("Hyperparameter tuning with ParamGridBuilder + CrossValidator needs spark-mllib; add it before running.")
    spark.stop()
  }
}
