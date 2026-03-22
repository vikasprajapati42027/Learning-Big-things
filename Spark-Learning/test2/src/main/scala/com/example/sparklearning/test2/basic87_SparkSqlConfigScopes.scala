package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic87_SparkSqlConfigScopes {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic87_SparkSqlConfigScopes").master("local[*]").getOrCreate()

    spark.conf.set("spark.sql.shuffle.partitions", 4)
    println("Global conf shuffle partitions: " + spark.conf.get("spark.sql.shuffle.partitions"))

    spark.sql("set spark.sql.autoBroadcastJoinThreshold=2097152")
    val confs = spark.sql("set spark.sql.autoBroadcastJoinThreshold").collect()
    confs.foreach(println)

    spark.stop()
  }
}
