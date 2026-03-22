package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic13_SparkSkewHandling {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic13_SparkSkewHandling").master("local[*]").getOrCreate()
    import spark.implicits._

    val skewed = Seq.fill(1000)(1) ++ Seq.fill(20)(2) ++ Seq.fill(5)(3)
    val df = spark.createDataset(skewed).toDF("key")

    val salted = df.withColumn("salt", (rand() * 8).cast("int"))
      .withColumn("salted_key", concat(col("key"), lit("_"), col("salt")))

    val aggregated = salted.groupBy("salted_key").count()
    aggregated.orderBy(desc("count")).show(5, truncate = false)

    spark.stop()
  }
}
