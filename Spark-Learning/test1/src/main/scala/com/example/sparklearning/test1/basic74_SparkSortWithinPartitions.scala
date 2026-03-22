package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic74_SparkSortWithinPartitions {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic74_SparkSortWithinPartitions").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((2, "b"), (1, "a"), (3, "c")).toDF("id", "label").repartition(2)
    val sorted = df.sortWithinPartitions("id")
    println(s"partitions -> ${sorted.rdd.getNumPartitions}")
    sorted.show()

    spark.stop()
  }
}
