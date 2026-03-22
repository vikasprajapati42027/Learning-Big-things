package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic83_SparkExplainCodegen {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic83_SparkExplainCodegen").master("local[*]").getOrCreate()
    spark.range(0, 5).explain("codegen")
    spark.stop()
  }
}
