package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic66_SparkShufflePartitionsTuning {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic66_SparkShufflePartitionsTuning")
      .master("local[*]")
      .config("spark.sql.shuffle.partitions", "16")
      .getOrCreate()
    import spark.implicits._

    val df = spark.range(0, 100000).withColumn("g", col("id") % 20)
    df.groupBy("g").count().show()
    println("Set shuffle partitions to 16 for this demo.")
    spark.stop()
  }
}
