package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic85_SparkExchangeReuse {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic85_SparkExchangeReuse").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = spark.range(0, 100).withColumn("g", col("id") % 5)
    val a = df.groupBy("g").count()
    val b = df.groupBy("g").avg("id")
    a.join(b, "g").explain(true)
    spark.stop()
  }
}
