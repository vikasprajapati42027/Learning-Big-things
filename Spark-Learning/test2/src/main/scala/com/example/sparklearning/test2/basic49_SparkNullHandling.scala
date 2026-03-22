package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic49_SparkNullHandling {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic49_SparkNullHandling").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((1, Some("a")), (2, None)).toDF("id", "val")
    df.na.fill("missing", Seq("val")).show()
    df.select(coalesce(col("val"), lit("fallback")).as("val_coalesced")).show()

    spark.stop()
  }
}
