package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic72_SparkSkewJoinHint {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic72_SparkSkewJoinHint").master("local[*]").getOrCreate()
    import spark.implicits._

    val big = (1 to 1000).map(i => (if (i % 2 == 0) 1 else i, s"row-$i")).toDF("id", "txt")
    val dim = Seq((1, "hotspot"), (2, "other")).toDF("id", "label")

    val hinted = big.hint("SKEW").join(dim, "id")
    hinted.explain()
    hinted.show(5)

    spark.stop()
  }
}
