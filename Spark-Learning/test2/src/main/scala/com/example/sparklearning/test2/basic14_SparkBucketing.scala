package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic14_SparkBucketing {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic14_SparkBucketing").master("local[*]").getOrCreate()
    import spark.implicits._

    val users = Seq((1, "alice"), (2, "bob"), (3, "carol"), (4, "dave"), (5, "erin"))
      .toDF("user_id", "name")

    val bucketLike = users.repartitionByRange(4, col("user_id"))
    println(s"Repartitioned to ${bucketLike.rdd.getNumPartitions} partitions as a stand-in for bucketing.")
    bucketLike.write.mode("overwrite").parquet("tmp_bucket_like_users")
    println("True bucketing (bucketBy/saveAsTable) requires Hive support; this demo uses range repartition instead.")

    spark.stop()
  }
}
