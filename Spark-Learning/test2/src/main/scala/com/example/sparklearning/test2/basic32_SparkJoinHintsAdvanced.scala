package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic32_SparkJoinHintsAdvanced {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic32_SparkJoinHintsAdvanced").master("local[*]").getOrCreate()
    import spark.implicits._

    val big = spark.range(0, 1000).toDF("id")
    val small = spark.range(0, 10).toDF("id").withColumn("flag", lit(1))

    val broadcasted = big.hint("broadcast").join(small, "id")
    broadcasted.explain(true)

    val shuffled = big.hint("shuffle_hash").join(small, "id")
    shuffled.explain(true)

    spark.stop()
  }
}
