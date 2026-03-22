package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic24_SparkSkewHint {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic24_SparkSkewHint").master("local[*]").getOrCreate()
    import spark.implicits._

    val skewed = Seq.fill(50)("hot") ++ Seq("cold", "warm")
    val df = skewed.toDF("key")
    val counts = df.hint("SKIP").groupBy("key").agg(count("*").as("cnt"))
    counts.explain()
    counts.show()

    spark.stop()
  }
}
