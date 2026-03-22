package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic44_HiveCollectList {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic44_HiveCollectList")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS coll_actions")
    spark.sql("CREATE TABLE coll_actions(user STRING, action STRING) STORED AS PARQUET")
    spark.sql("INSERT INTO coll_actions VALUES ('alice','click'),('alice','view'),('bob','view')")

    spark.sql("SELECT user, collect_list(action) as actions FROM coll_actions GROUP BY user").show(false)
    spark.stop()
  }
}
