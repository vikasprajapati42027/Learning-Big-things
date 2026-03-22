package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic52_HiveUnionAll {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic52_HiveUnionAll").master("local[*]").enableHiveSupport().getOrCreate()

    spark.sql("WITH a AS (SELECT 1 as id), b AS (SELECT 2 as id) SELECT * FROM a UNION ALL SELECT * FROM b").show()
    spark.stop()
  }
}
