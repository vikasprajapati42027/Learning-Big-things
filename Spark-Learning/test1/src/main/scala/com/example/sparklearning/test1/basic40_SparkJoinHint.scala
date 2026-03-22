package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.broadcast

object basic40_SparkJoinHint {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic40_SparkJoinHint").master("local[*]").getOrCreate()
    import spark.implicits._

    val big = (1 to 1000).map(i => (i, s"big-$i")).toDF("id", "name")
    val small = Seq((1, "x"), (2, "y")).toDF("id", "flag")

    val hinted = big.join(broadcast(small.hint("broadcast")), Seq("id"))
    hinted.explain()
    hinted.show()

    spark.stop()
  }
}
