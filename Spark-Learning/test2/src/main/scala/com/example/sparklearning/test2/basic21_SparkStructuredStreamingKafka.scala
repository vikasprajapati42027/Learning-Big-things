package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic21_SparkStructuredStreamingKafka {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic21_SparkStructuredStreamingKafka").master("local[*]").getOrCreate()
    println("Kafka source/sink needs spark-sql-kafka-0-10 and configured bootstrap servers + topics before running.")
    spark.stop()
  }
}
