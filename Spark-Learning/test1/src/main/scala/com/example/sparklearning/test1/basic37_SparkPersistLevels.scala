package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel

object basic37_SparkPersistLevels {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic37_SparkPersistLevels").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = (1 to 100000).toDF("value")
    df.persist(StorageLevel.MEMORY_ONLY)
    df.count()
    println(s"storage level -> ${df.storageLevel.description}")

    spark.stop()
  }
}
