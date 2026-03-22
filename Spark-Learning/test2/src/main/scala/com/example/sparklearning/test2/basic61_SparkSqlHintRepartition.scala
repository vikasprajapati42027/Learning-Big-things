package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic61_SparkSqlHintRepartition {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic61_SparkSqlHintRepartition").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = spark.range(0, 100).withColumn("bucket", col("id") % 5)
    df.hint("REPARTITION", 3, col("bucket")).groupBy("bucket").count().explain(true)
    spark.stop()
  }
}
