package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic64_SparkDynamicPartitionPruning {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic64_SparkDynamicPartitionPruning")
      .master("local[*]")
      .config("spark.sql.optimizer.dynamicPartitionPruning.enabled", "true")
      .getOrCreate()
    import spark.implicits._

    val fact = spark.range(0, 1000).withColumn("dt", (col("id") % 10).cast("string"))
    val dim = spark.range(0, 3).withColumn("dt", (col("id") % 10).cast("string"))

    fact.write.mode("overwrite").partitionBy("dt").parquet("dpp-fact")
    dim.write.mode("overwrite").parquet("dpp-dim")

    val factRead = spark.read.parquet("dpp-fact")
    val dimRead = spark.read.parquet("dpp-dim")
    factRead.join(dimRead, "dt").explain(true)
    spark.stop()
  }
}
