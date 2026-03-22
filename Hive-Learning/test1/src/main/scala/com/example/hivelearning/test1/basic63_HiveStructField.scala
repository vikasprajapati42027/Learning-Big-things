package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic63_HiveStructField {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic63_HiveStructField").master("local[*]").enableHiveSupport().getOrCreate()

    spark.sql("SELECT named_struct('name','alice','age',30) as person").show(false)
    spark.sql("SELECT (named_struct('name','alice','age',30)).name as person_name").show(false)

    spark.stop()
  }
}
