package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

case class Word(text: String, len: Int)

object basic38_SparkDatasetMap {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic38_SparkDatasetMap").master("local[*]").getOrCreate()
    import spark.implicits._

    val ds = Seq("alpha", "beta").toDS()
    val mapped = ds.map(word => Word(word, word.length))
    mapped.show()

    spark.stop()
  }
}
