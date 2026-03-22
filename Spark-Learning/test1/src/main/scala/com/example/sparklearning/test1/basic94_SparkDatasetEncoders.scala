package com.example.sparklearning.test1

import org.apache.spark.sql.{Encoder, Encoders, SparkSession}

object basic94_SparkDatasetEncoders {
  case class Person(name: String, age: Int)

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic94_SparkDatasetEncoders").master("local[*]").getOrCreate()
    import spark.implicits._

    implicit val personEncoder: Encoder[Person] = Encoders.product[Person]
    val ds = Seq(Person("alice", 30)).toDS()
    ds.show()

    spark.stop()
  }
}
