package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic1_SparkDatasetBasics {
  def main(args: Array[String]): Unit = {
    // start Spark locally for quick experimentation
    val spark = SparkSession.builder()
      .appName("basic1_SparkDatasetBasics")
      .master("local[*]")
      .getOrCreate()

    import spark.implicits._

    // build a typed Dataset of case class rows
    case class Person(name: String, age: Int)
    val people = Seq(Person("alice", 30), Person("bob", 25), Person("carol", 40)).toDS()

    // select + filter operations stay type-safe on Dataset
    val adults = people.filter(_.age >= 30).select("name", "age")

    adults.show()
    adults.printSchema()

    spark.stop()
  }
}
