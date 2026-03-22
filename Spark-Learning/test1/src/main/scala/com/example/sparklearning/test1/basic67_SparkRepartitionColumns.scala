package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic67_SparkRepartitionColumns {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic67_SparkRepartitionColumns").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((1, "a"), (2, "b"), (3, "a")).toDF("id", "key")
    val repart = df.repartition($"key")
    println(s"partitions after repartition by key -> ${repart.rdd.getNumPartitions}")

    spark.stop()
  }
}
