package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic43_SparkJsonReadWrite {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic43_SparkJsonReadWrite").master("local[*]").getOrCreate()

    val df = spark.read.json(spark.sparkContext.parallelize(Seq("""{"id":1,"name":"alice"}""", """{"id":2,"name":"bob"}""")))
    df.printSchema()
    df.write.mode("overwrite").json("tmp-json-out")
    spark.stop()
  }
}
