package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic5_SparkParquetIO {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic5_SparkParquetIO").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((1, "alpha"), (2, "beta")).toDF("id", "name")
    val path = "./tmp/test2_basic5_parquet"
    df.write.mode("overwrite").parquet(path)
    spark.read.parquet(path).show()

    spark.stop()
  }
}
