package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic97_SparkDatasetFlatMap {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic97_SparkDatasetFlatMap").master("local[*]").getOrCreate()
    import spark.implicits._

    val ds = Seq("a b", "c").toDS()
    ds.flatMap(_.split(" ")).show()

    spark.stop()
  }
}
