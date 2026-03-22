package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic2_SparkDataframeJoins {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic2_SparkDataframeJoins")
      .master("local[*]")
      .getOrCreate()

    import spark.implicits._

    val users = Seq((1, "alice"), (2, "bob"), (3, "carol")).toDF("id", "name")
    val orders = Seq((1, 2), (2, 5)).toDF("user_id", "order_count")

    val joined = users.join(orders, users("id") === orders("user_id"), "left")
    joined.show()
    joined.printSchema()

    spark.stop()
  }
}
