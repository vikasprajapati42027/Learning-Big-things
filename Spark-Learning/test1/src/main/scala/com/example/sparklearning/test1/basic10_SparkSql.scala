package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic10_SparkSql {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic10_SparkSql").master("local[*]").getOrCreate()
    import spark.implicits._
    val df = Seq(("a", 1), ("b", 2)).toDF("tag", "value")
    df.createOrReplaceTempView("events")
    spark.sql("select tag, sum(value) as total from events group by tag").show()
    spark.stop()
  }
}
