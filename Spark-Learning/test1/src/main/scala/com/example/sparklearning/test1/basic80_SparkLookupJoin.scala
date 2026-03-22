package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.broadcast

object basic80_SparkLookupJoin {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic80_SparkLookupJoin").master("local[*]").getOrCreate()
    import spark.implicits._

    val fact = Seq((1, 10), (2, 20), (3, 30)).toDF("id", "amount")
    val dim = Seq((1, "gold"), (2, "silver")).toDF("id", "tier")
    fact.join(broadcast(dim), Seq("id"), "left").show()

    spark.stop()
  }
}
