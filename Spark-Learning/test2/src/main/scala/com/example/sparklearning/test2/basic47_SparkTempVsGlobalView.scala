package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic47_SparkTempVsGlobalView {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic47_SparkTempVsGlobalView").master("local[*]").getOrCreate()

    spark.range(0, 5).createOrReplaceTempView("local_ids")
    spark.range(5, 10).createGlobalTempView("global_ids")

    spark.sql("select * from local_ids").show()
    spark.sql("select * from global_temp.global_ids").show()

    spark.stop()
  }
}
