package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic69_HiveMapKeysValues {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic69_HiveMapKeysValues").master("local[*]").enableHiveSupport().getOrCreate()

    spark.sql("SELECT map_keys(map('a',1,'b',2)) as keys, map_values(map('a',1,'b',2)) as vals").show(false)
    spark.stop()
  }
}
