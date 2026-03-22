package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic11_SparkJsonLoad {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic11_SparkJsonLoad").master("local[*]").getOrCreate()

    // create tiny in-memory JSON lines and load via DataFrame reader
    val jsonRdd = spark.sparkContext.parallelize(Seq(
      "{\"name\":\"alice\",\"age\":30}",
      "{\"name\":\"bob\",\"age\":25}"
    ))

    val df = spark.read.json(jsonRdd)
    df.show()
    df.printSchema()

    spark.stop()
  }
}
