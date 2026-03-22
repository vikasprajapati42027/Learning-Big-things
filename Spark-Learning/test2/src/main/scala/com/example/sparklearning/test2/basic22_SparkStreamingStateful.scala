package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic22_SparkStreamingStateful {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic22_SparkStreamingStateful").master("local[*]").getOrCreate()
    println("Stateful streaming (mapGroupsWithState/flatMapGroupsWithState) requires a streaming source; add one and define state logic.")
    spark.stop()
  }
}
