package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic70_SparkDropColumns {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic70_SparkDropColumns").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((1, "a", "x")).toDF("id", "v1", "v2")
    df.drop("v2").show()

    spark.stop()
  }
}
