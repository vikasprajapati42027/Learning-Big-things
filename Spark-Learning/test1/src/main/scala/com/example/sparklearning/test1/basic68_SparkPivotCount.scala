package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.count

object basic68_SparkPivotCount {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic68_SparkPivotCount").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq(("east", "A"), ("east", "B"), ("west", "A")).toDF("region", "code")
    df.groupBy("region").pivot("code").agg(count("*")).show()

    spark.stop()
  }
}
