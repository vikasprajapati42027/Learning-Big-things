package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.broadcast

object basic13_SparkBroadcastJoin {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic13_SparkBroadcastJoin").master("local[*]").getOrCreate()
    import spark.implicits._

    val large = (1 to 5).map(i => (i, s"user-$i")).toDF("id", "name")
    val small = Seq((1, "gold"), (2, "silver"), (5, "bronze")).toDF("id", "tier")

    val joined = large.join(broadcast(small), Seq("id"), "left")
    joined.show()

    spark.stop()
  }
}
