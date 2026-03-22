package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.streaming.Trigger

object basic90_SparkStreamingWatermarkJoin {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic90_SparkStreamingWatermarkJoin").master("local[*]").getOrCreate()

    val left = spark.readStream.format("rate").load().withWatermark("timestamp", "1 minute")
    val right = spark.readStream.format("rate").option("rowsPerSecond", 5).load().withWatermark("timestamp", "1 minute")

    val joined = left.join(right, expr("left.timestamp = right.timestamp"))

    val q = joined.writeStream.format("console").outputMode("append").option("checkpointLocation", "chk-basic90").trigger(Trigger.Once()).start()
    q.awaitTermination(5000)
    spark.stop()
  }
}
