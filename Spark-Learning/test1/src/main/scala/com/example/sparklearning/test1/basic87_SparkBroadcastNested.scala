package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic87_SparkBroadcastNested {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic87_SparkBroadcastNested").master("local[*]").getOrCreate()
    import spark.implicits._

    val fact = (1 to 5).toDF("id")
    val dim = Seq((1, "A"), (2, "B")).toDF("id", "label")

    val joined = fact.join(org.apache.spark.sql.functions.broadcast(dim), "id")
    joined.explain()
    joined.show()

    spark.stop()
  }
}
