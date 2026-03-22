package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic56_SparkParquetSchemaMerge {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic56_SparkParquetSchemaMerge").master("local[*]").getOrCreate()

    import spark.implicits._
    Seq((1, "a")).toDF("id", "val").write.mode("overwrite").parquet("parquet-merge")
    Seq((2, "b", "extra")).toDF("id", "val", "note").write.mode("append").parquet("parquet-merge")

    val merged = spark.read.option("mergeSchema", "true").parquet("parquet-merge")
    merged.printSchema()
    merged.show()

    spark.stop()
  }
}
