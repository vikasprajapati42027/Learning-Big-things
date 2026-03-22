package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic27_SparkBucketedWrite {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic27_SparkBucketedWrite").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((1, "a"), (2, "b"), (3, "c")).toDF("id", "value")
    val path = "./tmp/basic27_buckets"

    df.write.bucketBy(2, "id").sortBy("id").mode("overwrite").saveAsTable("bucket_demo")
    println("bucketed table 'bucket_demo' created (metastore required).")

    spark.stop()
  }
}
