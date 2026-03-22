package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic42_SparkCartesianProduct {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic42_SparkCartesianProduct").master("local[*]").getOrCreate()
    import spark.implicits._

    val left = Seq(1, 2).toDF("x")
    val right = Seq("p", "q").toDF("y")
    val cart = left.crossJoin(right)
    cart.show()

    spark.stop()
  }
}
