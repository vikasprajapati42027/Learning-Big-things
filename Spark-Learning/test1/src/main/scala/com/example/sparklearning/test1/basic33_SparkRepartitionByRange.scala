package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic33_SparkRepartitionByRange {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic33_SparkRepartitionByRange").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = (1 to 20).toDF("value")
    val ranged = df.repartitionByRange(4, $"value")
    println(s"range-partitioned -> ${ranged.rdd.getNumPartitions} partitions")
    ranged.show()

    spark.stop()
  }
}
