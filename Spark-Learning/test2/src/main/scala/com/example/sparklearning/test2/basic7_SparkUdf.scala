package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.udf

object basic7_SparkUdf {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic7_SparkUdf").master("local[*]").getOrCreate()
    import spark.implicits._

    val upper = udf((s: String) => s.toUpperCase)
    val df = Seq("alpha", "beta").toDF("word")
    df.withColumn("upper", upper(df("word"))).show()

    spark.stop()
  }
}
