package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic75_SparkReplaceWhere {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic75_SparkReplaceWhere").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((2023, "old"), (2024, "new")).toDF("year", "value")
    val path = "./tmp/basic75_replacewhere"
    df.write.mode("overwrite").partitionBy("year").parquet(path)

    val updated = Seq((2024, "updated")).toDF("year", "value")
    updated.write.mode("overwrite").option("replaceWhere", "year = 2024").parquet(path)

    spark.read.parquet(path).show()
    spark.stop()
  }
}
