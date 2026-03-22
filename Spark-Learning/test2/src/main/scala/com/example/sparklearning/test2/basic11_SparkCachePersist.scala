package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic11_SparkCachePersist {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic11_SparkCachePersist").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = (1 to 100000).toDF("n").withColumn("squared", pow(col("n"), 2))

    df.cache() // default MEMORY_AND_DISK
    println(s"Count after cache: ${df.count()}")

    val persisted = df.persist(org.apache.spark.storage.StorageLevel.MEMORY_ONLY)
    println(s"Count after persist: ${persisted.count()}")

    df.unpersist()
    persisted.unpersist()
    spark.stop()
  }
}
