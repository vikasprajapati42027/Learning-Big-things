package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.streaming.Trigger

object basic19_SparkStructuredStreamingWatermark {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic19_SparkStructuredStreamingWatermark").master("local[*]").getOrCreate()

    val stream = spark.readStream.format("rate").option("rowsPerSecond", 5).load()
      .withWatermark("timestamp", "1 minute")
      .groupBy(window(col("timestamp"), "30 seconds"))
      .count()

    val query = stream.writeStream
      .format("console")
      .option("truncate", false)
      .outputMode("complete")
      .trigger(Trigger.Once())
      .start()

    query.awaitTermination(5000)
    spark.stop()
  }
}
