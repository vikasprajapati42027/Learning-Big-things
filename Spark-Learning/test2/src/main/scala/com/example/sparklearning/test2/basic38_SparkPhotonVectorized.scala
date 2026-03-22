package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic38_SparkPhotonVectorized {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic38_SparkPhotonVectorized").master("local[*]").getOrCreate()
    println("Photon/vectorized execution is Databricks-specific; for open-source Spark use vectorized Parquet/ORC readers and predicate pushdown.")
    spark.stop()
  }
}
