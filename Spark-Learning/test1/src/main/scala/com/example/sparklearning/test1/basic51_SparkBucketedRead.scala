package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic51_SparkBucketedRead {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic51_SparkBucketedRead").master("local[*]").getOrCreate()
    // Note: requires bucketed table from basic27; falls back gracefully if missing
    spark.sql("SHOW TABLES LIKE 'bucket_demo'").show()
    spark.stop()
  }
}
