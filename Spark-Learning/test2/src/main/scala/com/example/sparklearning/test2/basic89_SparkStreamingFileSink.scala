package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.streaming.Trigger

object basic89_SparkStreamingFileSink {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic89_SparkStreamingFileSink").master("local[*]").getOrCreate()

    val stream = spark.readStream.format("rate").option("rowsPerSecond", 3).load()
      .withColumn("ts", col("timestamp").cast("string"))

    val q = stream.writeStream
      .format("json")
      .option("path", "stream-out")
      .option("checkpointLocation", "chk-basic89")
      .outputMode("append")
      .trigger(Trigger.Once())
      .start()

    q.awaitTermination(5000)
    spark.stop()
  }
}
