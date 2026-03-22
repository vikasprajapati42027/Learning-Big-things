package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

object basic8_SparkWindow {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic8_SparkWindow").master("local[*]").getOrCreate()
    import spark.implicits._
    val df = Seq(("Alice", 10), ("Alice", 20), ("Bob", 15)).toDF("name", "score")
    val windowSpec = Window.partitionBy("name").orderBy(col("score").desc)
    df.withColumn("rank", dense_rank().over(windowSpec)).show()
    spark.stop()
  }
}
