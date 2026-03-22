package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic10_SparkExplain {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic10_SparkExplain").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = (1 to 10).toDF("n").filter("n > 5").selectExpr("n * 2 as doubled")
    df.explain(true)
    df.show()

    spark.stop()
  }
}
