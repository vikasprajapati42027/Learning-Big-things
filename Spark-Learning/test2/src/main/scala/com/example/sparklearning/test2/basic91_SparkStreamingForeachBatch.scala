package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.streaming.Trigger

object basic91_SparkStreamingForeachBatch {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic91_SparkStreamingForeachBatch").master("local[*]").getOrCreate()

    val stream = spark.readStream.format("rate").option("rowsPerSecond", 3).load()

    val q = stream.writeStream
      .foreachBatch { (batch, batchId) =>
        println(s"Batch $batchId rows: ${batch.count()}")
      }
      .trigger(Trigger.Once())
      .start()

    q.awaitTermination(5000)
    spark.stop()
  }
}
