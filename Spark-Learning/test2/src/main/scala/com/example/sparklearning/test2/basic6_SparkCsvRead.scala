package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic6_SparkCsvRead {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic6_SparkCsvRead").master("local[*]").getOrCreate()

    val sample = Seq("id,name", "1,Alice", "2,Bob")
    val path = "./tmp/test2_basic6.csv"
    import java.nio.file.{Files, Paths}
    Files.write(Paths.get(path), sample.mkString("\n").getBytes())

    val df = spark.read.option("header", "true").csv(path)
    df.show()

    spark.stop()
  }
}
