package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

case class Event(tag: String, value: Int)

object basic9_SparkDataset {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic9_SparkDataset").master("local[*]").getOrCreate()
    import spark.implicits._
    val ds = Seq(Event("a", 1), Event("b", 2)).toDS()
    ds.filter(_.value > 1).show()
    spark.stop()
  }
}
