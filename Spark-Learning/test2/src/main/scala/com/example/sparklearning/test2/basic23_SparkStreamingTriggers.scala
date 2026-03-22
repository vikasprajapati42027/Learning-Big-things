package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic23_SparkStreamingTriggers {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic23_SparkStreamingTriggers").master("local[*]").getOrCreate()
    println("Use Trigger.Once for batch-like execution, Trigger.ProcessingTime for steady micro-batches, Trigger.Continuous where supported.")
    spark.stop()
  }
}
