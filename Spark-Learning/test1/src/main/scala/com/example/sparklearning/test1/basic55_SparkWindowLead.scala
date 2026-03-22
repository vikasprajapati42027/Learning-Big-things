package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

object basic55_SparkWindowLead {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic55_SparkWindowLead").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq(
      ("alice", 1, 10),
      ("alice", 2, 15),
      ("bob", 1, 5)
    ).toDF("user", "step", "score")

    val w = Window.partitionBy("user").orderBy("step")
    df.withColumn("next_score", lead($"score", 1).over(w)).show()

    spark.stop()
  }
}
