package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic92_SparkDatasetGroupBy {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic92_SparkDatasetGroupBy").master("local[*]").getOrCreate()
    import spark.implicits._

    val ds = Seq(("a", 1), ("a", 2), ("b", 3)).toDS()
    ds.groupByKey(_._1).count().show()

    spark.stop()
  }
}
