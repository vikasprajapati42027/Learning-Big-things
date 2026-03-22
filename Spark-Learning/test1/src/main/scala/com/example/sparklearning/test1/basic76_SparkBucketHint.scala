package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic76_SparkBucketHint {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic76_SparkBucketHint").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((1, "a"), (2, "b")).toDF("id", "val").hint("BUCKET", "id")
    df.explain()
    spark.stop()
  }
}
