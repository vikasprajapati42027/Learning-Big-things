package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic91_SparkDatasetFilter {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic91_SparkDatasetFilter").master("local[*]").getOrCreate()
    import spark.implicits._

    val ds = Seq(1, 2, 3, 4, 5).toDS()
    ds.filter(_ % 2 == 0).show()

    spark.stop()
  }
}
