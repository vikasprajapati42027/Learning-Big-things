package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic26_SparkRangeJoin {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic26_SparkRangeJoin").master("local[*]").getOrCreate()
    import spark.implicits._

    val events = Seq((1, 5), (2, 15), (3, 25)).toDF("id", "value")
    val ranges = Seq((0, 10, "low"), (10, 20, "mid"), (20, 30, "high")).toDF("min", "max", "bucket")

    val joined = events.join(ranges, events("value") >= ranges("min") && events("value") < ranges("max"))
    joined.show()

    spark.stop()
  }
}
