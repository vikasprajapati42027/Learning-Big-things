package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic79_SparkZipWithIndex {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic79_SparkZipWithIndex").master("local[*]").getOrCreate()

    val rdd = spark.sparkContext.parallelize(Seq("a", "b", "c"))
    val indexed = rdd.zipWithIndex().collect()
    println(indexed.mkString(", "))

    spark.stop()
  }
}
