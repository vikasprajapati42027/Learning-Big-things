package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic73_SparkBloomFilterJoin {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic73_SparkBloomFilterJoin")
      .master("local[*]")
      .config("spark.sql.bloomFilter.enabled", "true")
      .getOrCreate()
    import spark.implicits._

    val dim = spark.range(0, 1000).withColumn("k", col("id")).cache()
    val fact = spark.range(0, 100000).withColumn("k", col("id") % 1000)
    dim.createOrReplaceTempView("dim")
    fact.createOrReplaceTempView("fact")

    spark.sql("select /*+ BLOOMFILTER(dim, k, 0.1) */ * from fact join dim using(k)").explain(true)
    spark.stop()
  }
}
