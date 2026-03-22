package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic97_SparkOrcPredicatePushdown {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic97_SparkOrcPredicatePushdown").master("local[*]").getOrCreate()

    val df = spark.range(0, 100)
    df.write.mode("overwrite").orc("ppd-orc")
    spark.read.orc("ppd-orc").filter("id < 5").explain(true)

    spark.stop()
  }
}
