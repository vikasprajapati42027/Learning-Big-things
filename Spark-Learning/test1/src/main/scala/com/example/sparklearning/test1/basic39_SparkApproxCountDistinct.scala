package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic39_SparkApproxCountDistinct {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic39_SparkApproxCountDistinct").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq.fill(1000)("repeat") ++ Seq("unique1", "unique2")
    val counts = df.toDF("value").agg(expr("approx_count_distinct(value, 0.05) as approxDistinct"))
    counts.show()

    spark.stop()
  }
}
