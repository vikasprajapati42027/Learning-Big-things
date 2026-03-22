package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic25_SparkMlClassification {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic25_SparkMlClassification").master("local[*]").getOrCreate()
    println("Classification demo (LogisticRegression) requires spark-mllib; add dependency and wire a Pipeline with evaluator.")
    spark.stop()
  }
}
