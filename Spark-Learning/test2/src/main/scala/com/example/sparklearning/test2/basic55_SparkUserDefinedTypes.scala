package com.example.sparklearning.test2

import org.apache.spark.sql.{Encoder, Encoders, SparkSession}
import org.apache.spark.sql.types.StructType

object basic55_SparkUserDefinedTypes {
  case class Point(x: Double, y: Double)
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic55_SparkUserDefinedTypes").master("local[*]").getOrCreate()
    import spark.implicits._

    implicit val pointEncoder: Encoder[Point] = Encoders.product[Point]
    val ds = Seq(Point(1.0, 2.0), Point(3.0, 4.0)).toDS()
    ds.show()

    println("Custom UDTs require registering a UDT class; here we rely on case class encoder instead for simplicity.")
    spark.stop()
  }
}
