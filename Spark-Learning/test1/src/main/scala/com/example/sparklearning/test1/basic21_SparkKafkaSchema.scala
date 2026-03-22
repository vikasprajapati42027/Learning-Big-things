package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._

object basic21_SparkKafkaSchema {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic21_SparkKafkaSchema").master("local[*]").getOrCreate()

    // build an example schema you might apply to Kafka value bytes
    val valueSchema = StructType(Seq(
      StructField("id", IntegerType, nullable = false),
      StructField("event", StringType, nullable = false),
      StructField("ts", LongType, nullable = false)
    ))
    println(s"example schema -> $valueSchema")

    spark.stop()
  }
}
