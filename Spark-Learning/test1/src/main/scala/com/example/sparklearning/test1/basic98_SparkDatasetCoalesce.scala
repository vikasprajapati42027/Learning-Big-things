package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic98_SparkDatasetCoalesce {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic98_SparkDatasetCoalesce").master("local[*]").getOrCreate()
    import spark.implicits._

    val ds = (1 to 10).toDS().repartition(4)
    println(s"before coalesce -> ${ds.rdd.getNumPartitions}")
    val shrunk = ds.coalesce(2)
    println(s"after coalesce -> ${shrunk.rdd.getNumPartitions}")

    spark.stop()
  }
}
