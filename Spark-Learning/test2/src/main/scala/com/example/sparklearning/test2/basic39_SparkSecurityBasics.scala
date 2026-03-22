package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic39_SparkSecurityBasics {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic39_SparkSecurityBasics").master("local[*]").getOrCreate()
    println("Review configs for encryption (spark.io.encryption.enabled, spark.ssl.enabled), auth (spark.authenticate), and integrate Ranger/Sentry where applicable.")
    spark.stop()
  }
}
