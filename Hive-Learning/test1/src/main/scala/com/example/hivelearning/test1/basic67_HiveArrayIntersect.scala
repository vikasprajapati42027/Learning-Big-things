package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic67_HiveArrayIntersect {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic67_HiveArrayIntersect").master("local[*]").enableHiveSupport().getOrCreate()

    spark.sql("SELECT array_intersect(array(1,2,3), array(2,3,4)) as inter").show(false)
    spark.stop()
  }
}
