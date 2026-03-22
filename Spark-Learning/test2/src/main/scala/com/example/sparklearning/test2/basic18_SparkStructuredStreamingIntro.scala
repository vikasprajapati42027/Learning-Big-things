package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.streaming.Trigger

object basic18_SparkStructuredStreamingIntro {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic18_SparkStructuredStreamingIntro").master("local[*]").getOrCreate()

    val stream = spark.readStream.format("rate").option("rowsPerSecond", 2).load()
      .withColumn("doubled", col("value") * 2)

    val query = stream.writeStream
      .format("console")
      .option("truncate", false)
      .outputMode("append")
      .trigger(Trigger.Once())
      .start()

    query.awaitTermination(5000)
    spark.stop()
  }
}
