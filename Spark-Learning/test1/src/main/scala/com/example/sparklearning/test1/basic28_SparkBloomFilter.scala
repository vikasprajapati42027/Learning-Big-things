package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic28_SparkBloomFilter {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic28_SparkBloomFilter").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq("alice", "bob", "carol").toDF("name")
    val bloom = df.stat.bloomFilter("name", expectedNumItems = 1000, fpp = 0.01)

    println(s"maybe contains 'alice'? -> ${bloom.mightContain("alice")}")
    println(s"maybe contains 'dave'?  -> ${bloom.mightContain("dave")}")

    spark.stop()
  }
}
