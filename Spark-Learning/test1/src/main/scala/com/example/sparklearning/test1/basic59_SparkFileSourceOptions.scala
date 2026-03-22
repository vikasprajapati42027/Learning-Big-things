package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic59_SparkFileSourceOptions {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic59_SparkFileSourceOptions").master("local[*]").getOrCreate()

    println("supported data sources:")
    spark.sql("SHOW TABLES").show()
    println("default parallelism -> " + spark.sparkContext.defaultParallelism)

    spark.stop()
  }
}
