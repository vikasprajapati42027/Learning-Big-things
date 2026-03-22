package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.explode

object basic46_SparkJsonExplode {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic46_SparkJsonExplode").master("local[*]").getOrCreate()

    import spark.implicits._
    val json = Seq("""{"id":1,"tags":["a","b"]}""", """{"id":2,"tags":["c"]}""").toDS()
    val df = spark.read.json(json)
    df.withColumn("tag", explode($"tags")).drop("tags").show()

    spark.stop()
  }
}
