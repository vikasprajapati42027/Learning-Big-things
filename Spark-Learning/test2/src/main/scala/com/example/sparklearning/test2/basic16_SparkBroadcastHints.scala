package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic16_SparkBroadcastHints {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic16_SparkBroadcastHints").master("local[*]").getOrCreate()
    import spark.implicits._

    val facts = (1 to 100).toDF("user_id").withColumn("amount", rand() * 100)
    val dims = Seq((1, "A"), (2, "B"), (3, "C"), (4, "D")).toDF("user_id", "segment")

    val joined = facts.join(broadcast(dims), Seq("user_id"), "left")
    joined.groupBy("segment").agg(avg("amount").as("avg_spend")).show()

    spark.stop()
  }
}
