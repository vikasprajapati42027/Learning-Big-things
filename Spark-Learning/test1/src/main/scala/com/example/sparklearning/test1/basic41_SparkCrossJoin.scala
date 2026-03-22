package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic41_SparkCrossJoin {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic41_SparkCrossJoin").master("local[*]").getOrCreate()
    import spark.implicits._

    val left = Seq("a", "b").toDF("l")
    val right = Seq(1, 2, 3).toDF("r")
    left.crossJoin(right).show()

    spark.stop()
  }
}
