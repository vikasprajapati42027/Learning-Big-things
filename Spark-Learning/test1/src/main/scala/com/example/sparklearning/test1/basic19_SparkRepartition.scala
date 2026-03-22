package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic19_SparkRepartition {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic19_SparkRepartition").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = (1 to 50).toDF("value")
    println(s"initial partitions -> ${df.rdd.getNumPartitions}")
    val repart = df.repartition(6)
    println(s"after repartition -> ${repart.rdd.getNumPartitions}")
    val coalesced = repart.coalesce(2)
    println(s"after coalesce -> ${coalesced.rdd.getNumPartitions}")

    spark.stop()
  }
}
