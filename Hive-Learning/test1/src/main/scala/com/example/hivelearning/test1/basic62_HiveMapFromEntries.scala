package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic62_HiveMapFromEntries {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic62_HiveMapFromEntries").master("local[*]").enableHiveSupport().getOrCreate()

    spark.sql("SELECT map_from_entries(array(struct('k1','v1'), struct('k2','v2'))) as m").show(false)
    spark.stop()
  }
}
