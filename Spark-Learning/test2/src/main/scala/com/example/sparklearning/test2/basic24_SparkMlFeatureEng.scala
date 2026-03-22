package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic24_SparkMlFeatureEng {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic24_SparkMlFeatureEng").master("local[*]").getOrCreate()
    println("ML feature engineering examples (VectorAssembler, StringIndexer, OneHotEncoder) need spark-mllib dependency; add it to build.sbt before running.")
    spark.stop()
  }
}
