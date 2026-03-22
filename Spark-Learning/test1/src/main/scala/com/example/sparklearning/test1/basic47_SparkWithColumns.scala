package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic47_SparkWithColumns {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic47_SparkWithColumns").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((1, 10), (2, 20)).toDF("id", "value")
    val enriched = df
      .withColumn("double", col("value") * 2)
      .withColumn("ts", current_timestamp())
    enriched.show(false)

    spark.stop()
  }
}
