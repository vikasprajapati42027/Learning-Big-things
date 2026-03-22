package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic51_SparkCsvOptions {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic51_SparkCsvOptions").master("local[*]").getOrCreate()

    val df = spark.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv(spark.sparkContext.parallelize(Seq("id,name", "1,A", "2,B")))

    df.show()
    spark.stop()
  }
}
