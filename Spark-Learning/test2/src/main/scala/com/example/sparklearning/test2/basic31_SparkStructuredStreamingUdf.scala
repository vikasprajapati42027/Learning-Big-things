package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.streaming.Trigger

object basic31_SparkStructuredStreamingUdf {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic31_SparkStructuredStreamingUdf").master("local[*]").getOrCreate()

    val doubleUdf = udf((v: Long) => v * 2)
    val stream = spark.readStream.format("rate").load().withColumn("doubled", doubleUdf(col("value")))

    val q = stream.writeStream.format("console").outputMode("append").trigger(Trigger.Once()).start()
    q.awaitTermination(5000)
    spark.stop()
  }
}
