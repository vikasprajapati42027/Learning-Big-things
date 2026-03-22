package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic35_SparkRandomSplit {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic35_SparkRandomSplit").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = (1 to 10).toDF("value")
    val Array(train, test) = df.randomSplit(Array(0.7, 0.3), seed = 123)
    println(s"train count=${train.count()}, test count=${test.count()}")

    spark.stop()
  }
}
