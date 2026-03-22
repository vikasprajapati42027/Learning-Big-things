package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.streaming.Trigger

object basic92_SparkStreamingAvailableNow {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic92_SparkStreamingAvailableNow").master("local[*]").getOrCreate()

    val stream = spark.readStream.format("rate").option("rowsPerSecond", 5).load()
    val q = stream.writeStream.format("console").trigger(Trigger.AvailableNow()).start()
    q.awaitTermination()

    spark.stop()
  }
}
