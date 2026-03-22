package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic70_HiveSortArray {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic70_HiveSortArray").master("local[*]").enableHiveSupport().getOrCreate()

    spark.sql("SELECT sort_array(array(3,1,2)) as sorted").show(false)
    spark.stop()
  }
}
