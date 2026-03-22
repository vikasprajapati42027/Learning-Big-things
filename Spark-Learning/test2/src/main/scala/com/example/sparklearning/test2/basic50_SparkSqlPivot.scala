package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic50_SparkSqlPivot {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic50_SparkSqlPivot").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq(
      ("alice", "2019", 10),
      ("alice", "2020", 15),
      ("bob", "2019", 5)
    ).toDF("name", "year", "sales")

    val pivoted = df.groupBy("name").pivot("year").agg(sum("sales"))
    pivoted.show()

    spark.stop()
  }
}
