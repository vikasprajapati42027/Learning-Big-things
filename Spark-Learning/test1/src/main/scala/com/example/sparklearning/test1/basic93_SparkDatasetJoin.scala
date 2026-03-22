package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic93_SparkDatasetJoin {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic93_SparkDatasetJoin").master("local[*]").getOrCreate()
    import spark.implicits._

    val users = Seq((1, "alice"), (2, "bob")).toDS()
    val scores = Seq((1, 90), (3, 70)).toDS()

    users.toDF("id", "name").join(scores.toDF("id", "score"), Seq("id"), "left").show()

    spark.stop()
  }
}
