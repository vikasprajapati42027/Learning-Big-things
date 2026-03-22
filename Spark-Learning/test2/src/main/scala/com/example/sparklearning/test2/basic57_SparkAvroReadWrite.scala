package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic57_SparkAvroReadWrite {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic57_SparkAvroReadWrite").master("local[*]").getOrCreate()

    val df = spark.range(0, 3)
    df.write.mode("overwrite").format("avro").save("tmp-avro")
    val back = spark.read.format("avro").load("tmp-avro")
    back.show()

    println("Avro source requires spark-avro package on classpath in some distributions; works out-of-box on Spark 3.4+ binaries.")
    spark.stop()
  }
}
