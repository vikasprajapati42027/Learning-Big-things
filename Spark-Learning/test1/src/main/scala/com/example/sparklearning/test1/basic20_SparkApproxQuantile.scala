package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic20_SparkApproxQuantile {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic20_SparkApproxQuantile").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = (1 to 100).toDF("value")
    val quantiles = df.stat.approxQuantile("value", Array(0.25, 0.5, 0.75), 0.01)
    println(s"approx quantiles -> ${quantiles.mkString(", ")}")

    spark.stop()
  }
}
