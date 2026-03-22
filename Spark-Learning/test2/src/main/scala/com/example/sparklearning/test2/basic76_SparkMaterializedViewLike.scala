package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic76_SparkMaterializedViewLike {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic76_SparkMaterializedViewLike").master("local[*]").getOrCreate()

    val df = spark.range(0, 10)
    df.write.mode("overwrite").parquet("mv-like")
    val cached = spark.read.parquet("mv-like").cache()
    cached.count()
    cached.show()

    spark.stop()
  }
}
