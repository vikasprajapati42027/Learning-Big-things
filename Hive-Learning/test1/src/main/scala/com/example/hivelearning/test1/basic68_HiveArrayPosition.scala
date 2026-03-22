package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic68_HiveArrayPosition {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic68_HiveArrayPosition").master("local[*]").enableHiveSupport().getOrCreate()

    spark.sql("SELECT array_position(array('a','b','c'), 'b') as pos").show()
    spark.stop()
  }
}
