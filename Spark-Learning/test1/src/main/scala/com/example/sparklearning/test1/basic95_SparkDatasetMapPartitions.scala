package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic95_SparkDatasetMapPartitions {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic95_SparkDatasetMapPartitions").master("local[*]").getOrCreate()
    import spark.implicits._

    val ds = Seq(1, 2, 3, 4).toDS().repartition(2)
    val sizes = ds.mapPartitions(iter => Iterator(iter.size)).collect()
    println(s"partition sizes -> ${sizes.mkString(",")}")

    spark.stop()
  }
}
