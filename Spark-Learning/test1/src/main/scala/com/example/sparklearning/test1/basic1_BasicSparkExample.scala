package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, when}

object basic1_BasicSparkExample {
  def main(args: Array[String]): Unit = {
    // start a local Spark session; `local[*]` uses all cores for parallelism
    val spark = SparkSession.builder()
      .appName("BasicSparkExample")
      .master("local[*]")
      .getOrCreate()

    import spark.implicits._

    // simple sequence of tuples representing names and ages
    val people = Seq(
      ("alice", 34),
      ("bob", 29),
      ("carol", 42)
    )

    val df = people.toDF("name", "age")
    // print schema to verify Spark inferred correct column types
    df.printSchema()

    val enriched = df
      // add derived column to label each row and filter on age for meaningful subset
      .withColumn("age_group", when(col("age") >= 40, "senior").otherwise("adult"))
      .filter(col("age") >= 30)

    // display the small result set so we can see computed age groups
    enriched.show()

    // stop the Spark session to release threads/resources
    spark.stop()
  }
}
