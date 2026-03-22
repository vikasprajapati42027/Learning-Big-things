package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic17_SparkCheckpointing {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic17_SparkCheckpointing").master("local[*]").getOrCreate()
    spark.sparkContext.setCheckpointDir("checkpoint-basic17")

    val df = spark.range(0, 50).withColumn("double", col("id") * 2)
    val ck = df.checkpoint(eager = true)
    println(s"Checkpoint rows: ${ck.count()}")

    spark.stop()
  }
}
