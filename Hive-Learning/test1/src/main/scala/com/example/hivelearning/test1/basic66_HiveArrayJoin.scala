package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic66_HiveArrayJoin {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic66_HiveArrayJoin").master("local[*]").enableHiveSupport().getOrCreate()

    spark.sql("SELECT array_join(array('a','b','c'), '-') as joined").show(false)
    spark.stop()
  }
}
