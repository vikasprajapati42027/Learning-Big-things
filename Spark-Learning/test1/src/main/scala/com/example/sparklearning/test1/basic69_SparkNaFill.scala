package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic69_SparkNaFill {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic69_SparkNaFill").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((1, None: Option[String]), (2, Some("ok"))).toDF("id", "status")
    df.na.fill(Map("status" -> "missing")).show()

    spark.stop()
  }
}
