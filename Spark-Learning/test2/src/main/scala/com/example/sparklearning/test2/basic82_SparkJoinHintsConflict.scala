package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic82_SparkJoinHintsConflict {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic82_SparkJoinHintsConflict").master("local[*]").getOrCreate()
    import spark.implicits._

    val df1 = spark.range(0, 10).toDF("id")
    val df2 = spark.range(0, 10).toDF("id")

    df1.hint("BROADCAST").hint("SHUFFLE_HASH").join(df2, "id").explain(true)
    println("Conflicting hints: Spark picks one; check explain output.")
    spark.stop()
  }
}
