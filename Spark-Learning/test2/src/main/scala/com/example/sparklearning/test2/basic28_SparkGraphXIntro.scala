package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic28_SparkGraphXIntro {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic28_SparkGraphXIntro").master("local[*]").getOrCreate()
    println("GraphX lives in spark-graphx; add that dependency to explore PageRank/connected components.")
    spark.stop()
  }
}
