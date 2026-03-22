package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic96_SparkDatasetReduce {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic96_SparkDatasetReduce").master("local[*]").getOrCreate()
    import spark.implicits._

    val ds = Seq(1, 2, 3, 4).toDS()
    val sum = ds.reduce(_ + _)
    println(s"sum -> $sum")

    spark.stop()
  }
}
