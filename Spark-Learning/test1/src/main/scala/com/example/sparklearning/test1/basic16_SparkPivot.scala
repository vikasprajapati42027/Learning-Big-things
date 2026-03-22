package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.sum

object basic16_SparkPivot {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic16_SparkPivot").master("local[*]").getOrCreate()
    import spark.implicits._

    val sales = Seq(
      ("east", "Q1", 100),
      ("east", "Q2", 120),
      ("west", "Q1", 90)
    ).toDF("region", "quarter", "revenue")

    val pivoted = sales.groupBy("region").pivot("quarter").agg(sum("revenue"))
    pivoted.show()

    spark.stop()
  }
}
