package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic85_SparkJoinMultiple {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic85_SparkJoinMultiple").master("local[*]").getOrCreate()
    import spark.implicits._

    val users = Seq((1, "alice"), (2, "bob")).toDF("id", "name")
    val tiers = Seq((1, "gold"), (3, "silver")).toDF("id", "tier")
    val scores = Seq((1, 100), (2, 80)).toDF("id", "score")

    val joined = users.join(tiers, Seq("id"), "left").join(scores, Seq("id"), "left")
    joined.show()

    spark.stop()
  }
}
