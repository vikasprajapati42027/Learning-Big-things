package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic100_SparkDatasetSample {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic100_SparkDatasetSample").master("local[*]").getOrCreate()
    import spark.implicits._

    val ds = (1 to 50).toDS()
    ds.sample(withReplacement = false, fraction = 0.2, seed = 7).show()

    spark.stop()
  }
}
