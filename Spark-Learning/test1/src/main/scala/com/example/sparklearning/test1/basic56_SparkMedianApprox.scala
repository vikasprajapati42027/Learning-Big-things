package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.expr

object basic56_SparkMedianApprox {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic56_SparkMedianApprox").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = (1 to 21).toDF("value")
    val median = df.select(expr("percentile_approx(value, 0.5) as median"))
    median.show()

    spark.stop()
  }
}
