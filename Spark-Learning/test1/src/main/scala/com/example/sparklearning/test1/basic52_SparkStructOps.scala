package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic52_SparkStructOps {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic52_SparkStructOps").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((1, "alice", 30)).toDF("id", "name", "age")
    val structDf = df.select(struct($"name", $"age").as("profile"))
    structDf.select(col("profile.name"), col("profile.age")).show()

    spark.stop()
  }
}
