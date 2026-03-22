package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic31_SparkCubeRollup {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic31_SparkCubeRollup").master("local[*]").getOrCreate()
    import spark.implicits._

    val sales = Seq(
      ("east", "toy", 10),
      ("east", "book", 5),
      ("west", "toy", 7)
    ).toDF("region", "category", "units")

    println("ROLLUP region/category")
    sales.rollup("region", "category").agg(sum("units").as("total_units")).orderBy("region", "category").show()

    println("CUBE region/category")
    sales.cube("region", "category").agg(sum("units").as("total_units")).orderBy("region", "category").show()

    spark.stop()
  }
}
