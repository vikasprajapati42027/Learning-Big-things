package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

object basic25_SparkWindowLag {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic25_SparkWindowLag").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq(
      ("alice", "2024-01-01", 10),
      ("alice", "2024-01-02", 15),
      ("bob", "2024-01-01", 5)
    ).toDF("user", "date", "score")

    val w = Window.partitionBy("user").orderBy("date")
    df.withColumn("prev_score", lag(col("score"), 1).over(w)).show()

    spark.stop()
  }
}
