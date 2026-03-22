package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic44_SparkDatasetEncoders {
  case class Order(id: Long, customer: String, amount: Double)
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic44_SparkDatasetEncoders").master("local[*]").getOrCreate()
    import spark.implicits._

    val ds = Seq(Order(1, "alice", 10.5), Order(2, "bob", 20.0)).toDS()
    ds.filter(_.amount > 15).show()
    spark.stop()
  }
}
