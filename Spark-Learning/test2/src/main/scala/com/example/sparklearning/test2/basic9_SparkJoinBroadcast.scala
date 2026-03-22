package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.broadcast

object basic9_SparkJoinBroadcast {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic9_SparkJoinBroadcast").master("local[*]").getOrCreate()
    import spark.implicits._

    val fact = Seq((1, 100), (2, 200), (3, 300)).toDF("id", "amount")
    val dim = Seq((1, "gold"), (2, "silver")).toDF("id", "tier")

    fact.join(broadcast(dim), Seq("id"), "left").show()
    spark.stop()
  }
}
