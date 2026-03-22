package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic51_HiveDateFunctions {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic51_HiveDateFunctions").master("local[*]").enableHiveSupport().getOrCreate()

    spark.sql("SELECT current_date() as today, date_add(current_date(), 7) as plus7, date_format(current_timestamp(), 'yyyy-MM-dd HH:mm') as formatted").show(false)
    spark.stop()
  }
}
