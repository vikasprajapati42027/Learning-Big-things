package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic4_SparkJoins {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic4_SparkJoins").master("local[*]").getOrCreate()
    import spark.implicits._
    val left = Seq((1, "Alice"), (2, "Bob")).toDF("id", "name")
    val right = Seq((1, "NY"), (3, "LA")).toDF("id", "city")
    left.join(right, Seq("id"), "left").show()
    spark.stop()
  }
}
