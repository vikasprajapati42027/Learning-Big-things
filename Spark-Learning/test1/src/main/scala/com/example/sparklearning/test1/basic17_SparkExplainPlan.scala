package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic17_SparkExplainPlan {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic17_SparkExplainPlan").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = (1 to 10).toDF("value")
    val filtered = df.filter("value > 5").selectExpr("value * 2 as doubled")

    filtered.explain("formatted")
    filtered.show()

    spark.stop()
  }
}
