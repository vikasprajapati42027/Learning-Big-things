package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic58_SparkCacheTable {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic58_SparkCacheTable").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((1, "a"), (2, "b")).toDF("id", "val")
    df.createOrReplaceTempView("tmp_cache_demo")
    spark.catalog.cacheTable("tmp_cache_demo")
    spark.sql("select * from tmp_cache_demo").show()
    println(s"cached? -> ${spark.catalog.isCached("tmp_cache_demo")}")

    spark.stop()
  }
}
