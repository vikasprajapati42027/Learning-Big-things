package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic77_SparkSubqueryReuse {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic77_SparkSubqueryReuse").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = spark.range(0, 100).withColumn("g", col("id") % 5)
    df.createOrReplaceTempView("nums")
    spark.sql("select (select count(*) from nums) as total, g, count(*) c from nums group by g").explain(true)

    spark.stop()
  }
}
