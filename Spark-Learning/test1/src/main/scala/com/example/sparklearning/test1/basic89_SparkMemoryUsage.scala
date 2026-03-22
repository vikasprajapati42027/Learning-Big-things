package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic89_SparkMemoryUsage {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic89_SparkMemoryUsage").master("local[*]").getOrCreate()
    println(s"executor memory configured -> ${spark.conf.getOption("spark.executor.memory").getOrElse("default")}")
    spark.stop()
  }
}
