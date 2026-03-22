package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic42_SparkParquetCompression {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic42_SparkParquetCompression").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((1, "a"), (2, "b"), (3, "c")).toDF("id", "val")

    spark.conf.set("spark.sql.parquet.compression.codec", "snappy")
    df.write.mode("overwrite").parquet("parquet-snappy")
    spark.conf.set("spark.sql.parquet.compression.codec", "gzip")
    df.write.mode("overwrite").parquet("parquet-gzip")

    println("Wrote Parquet with snappy and gzip; compare file sizes under parquet-snappy/ and parquet-gzip/.")
    spark.stop()
  }
}
