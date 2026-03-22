package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic57_SparkSessionConf {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic57_SparkSessionConf").master("local[*]").config("spark.sql.shuffle.partitions", "5").getOrCreate()
    println(s"shuffle partitions -> ${spark.conf.get(\"spark.sql.shuffle.partitions\")}")
    spark.stop()
  }
}
