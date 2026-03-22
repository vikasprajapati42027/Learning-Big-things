package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel

object basic43_SparkCacheVsPersist {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic43_SparkCacheVsPersist").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = (1 to 1000).toDF("n")
    val cached = df.cache()
    cached.count()

    val persisted = df.persist(StorageLevel.MEMORY_AND_DISK)
    persisted.count()

    println(s"cache level -> ${cached.storageLevel}, persist level -> ${persisted.storageLevel}")
    spark.stop()
  }
}
