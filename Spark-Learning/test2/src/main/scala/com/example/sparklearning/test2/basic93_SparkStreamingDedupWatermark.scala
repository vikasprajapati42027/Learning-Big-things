package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.streaming.Trigger

object basic93_SparkStreamingDedupWatermark {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic93_SparkStreamingDedupWatermark").master("local[*]").getOrCreate()

    val stream = spark.readStream.format("rate").option("rowsPerSecond", 5).load()
      .withWatermark("timestamp", "1 minute")
      .dropDuplicates("timestamp")

    val q = stream.writeStream.format("console").outputMode("append").option("checkpointLocation", "chk-basic93").trigger(Trigger.Once()).start()
    q.awaitTermination(5000)

    spark.stop()
  }
}
