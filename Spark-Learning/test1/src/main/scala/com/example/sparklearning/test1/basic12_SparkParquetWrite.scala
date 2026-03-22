package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic12_SparkParquetWrite {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic12_SparkParquetWrite").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq(("east", 100), ("west", 200)).toDF("region", "sales")
    val path = "./tmp/basic12_parquet_output"

    df.write.mode("overwrite").parquet(path)
    println(s"wrote parquet to $path")

    spark.read.parquet(path).show()
    spark.stop()
  }
}
