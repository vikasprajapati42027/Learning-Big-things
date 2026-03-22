package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic99_SparkSqlSetOps {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic99_SparkSqlSetOps").master("local[*]").getOrCreate()

    val a = spark.range(0, 3)
    val b = spark.range(2, 5)

    a.union(b).show()
    a.intersect(b).show()
    a.except(b).show()

    spark.stop()
  }
}
