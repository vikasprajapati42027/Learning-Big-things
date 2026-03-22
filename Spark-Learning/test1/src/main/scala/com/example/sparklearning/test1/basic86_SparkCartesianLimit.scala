package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic86_SparkCartesianLimit {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic86_SparkCartesianLimit").master("local[*]").getOrCreate()
    import spark.implicits._

    val a = Seq("x", "y").toDF("a")
    val b = Seq(1, 2, 3).toDF("b")
    val limited = a.crossJoin(b).limit(4)
    limited.show()

    spark.stop()
  }
}
