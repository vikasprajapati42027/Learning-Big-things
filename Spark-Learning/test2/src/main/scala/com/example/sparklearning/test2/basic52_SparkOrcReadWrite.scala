package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic52_SparkOrcReadWrite {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic52_SparkOrcReadWrite").master("local[*]").getOrCreate()

    val df = spark.range(0, 5)
    df.write.mode("overwrite").orc("tmp-orc")
    val back = spark.read.orc("tmp-orc")
    back.show()

    spark.stop()
  }
}
