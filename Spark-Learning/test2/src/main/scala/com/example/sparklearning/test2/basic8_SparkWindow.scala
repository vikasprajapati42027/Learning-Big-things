package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

object basic8_SparkWindow {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic8_SparkWindow").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq(("alice", 10), ("alice", 20), ("bob", 5)).toDF("user", "score")
    val w = Window.partitionBy("user").orderBy(desc("score"))
    df.withColumn("rank", dense_rank().over(w)).show()

    spark.stop()
  }
}
