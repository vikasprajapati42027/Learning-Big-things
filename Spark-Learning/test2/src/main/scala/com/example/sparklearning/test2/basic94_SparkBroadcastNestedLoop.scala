package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic94_SparkBroadcastNestedLoop {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic94_SparkBroadcastNestedLoop").master("local[*]").getOrCreate()
    import spark.implicits._

    val a = spark.range(0, 5).toDF("id")
    val b = spark.range(0, 3).toDF("id")
    a.join(b.hint("BROADCAST_NL"), a("id") =!= b("id")).explain(true)

    spark.stop()
  }
}
