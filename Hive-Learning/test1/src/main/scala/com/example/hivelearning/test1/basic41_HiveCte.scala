package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic41_HiveCte {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic41_HiveCte")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("WITH t AS (SELECT stack(3, 'alice',30, 'bob',20, 'carol',40) as (name, age)) SELECT name FROM t WHERE age > 25").show()
    spark.stop()
  }
}
