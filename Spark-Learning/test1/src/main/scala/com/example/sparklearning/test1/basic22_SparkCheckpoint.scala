package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic22_SparkCheckpoint {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic22_SparkCheckpoint").master("local[*]").getOrCreate()
    spark.sparkContext.setCheckpointDir("./tmp/basic22_checkpoint")

    val rdd = spark.sparkContext.parallelize(1 to 100).map(_ * 2)
    rdd.checkpoint()
    println(s"count -> ${rdd.count()}")

    spark.stop()
  }
}
