package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.streaming.Trigger

object basic88_SparkStreamingCheckpointDir {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic88_SparkStreamingCheckpointDir").master("local[*]").getOrCreate()

    val stream = spark.readStream.format("rate").load()
    val q = stream.writeStream.format("console").option("checkpointLocation", "chk-basic88").trigger(Trigger.Once()).start()
    q.awaitTermination(5000)

    spark.stop()
  }
}
