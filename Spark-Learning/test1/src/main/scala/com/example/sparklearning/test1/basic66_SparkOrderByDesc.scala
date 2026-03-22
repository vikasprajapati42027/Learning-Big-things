package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.desc

object basic66_SparkOrderByDesc {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic66_SparkOrderByDesc").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((1, "b"), (2, "a")).toDF("id", "label")
    df.orderBy(desc("label")).show()

    spark.stop()
  }
}
