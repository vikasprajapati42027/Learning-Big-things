package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.udf

object basic84_SparkUdfNullSafe {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic84_SparkUdfNullSafe").master("local[*]").getOrCreate()
    import spark.implicits._

    val safeUpper = udf((s: String) => Option(s).map(_.toUpperCase).orNull)
    val df = Seq((1, "text"), (2, null.asInstanceOf[String])).toDF("id", "val")
    df.withColumn("upper", safeUpper(df("val"))).show()

    spark.stop()
  }
}
