package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic40_SparkDebugging {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic40_SparkDebugging")
      .master("local[*]")
      .config("spark.eventLog.enabled", "true")
      .config("spark.eventLog.dir", "logs/event-log")
      .getOrCreate()

    println(s"Spark UI: ${spark.sparkContext.uiWebUrl.getOrElse("not started")}")
    println("Enable event logs to inspect DAGs after runs; check logs/event-log directory.")
    spark.stop()
  }
}
