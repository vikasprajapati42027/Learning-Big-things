package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

object basic83_SparkWindowPercentRank {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic83_SparkWindowPercentRank").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq(("alice", 50), ("alice", 70), ("alice", 90)).toDF("user", "score")
    val w = Window.partitionBy("user").orderBy("score")
    df.withColumn("pct_rank", percent_rank().over(w)).show()

    spark.stop()
  }
}
