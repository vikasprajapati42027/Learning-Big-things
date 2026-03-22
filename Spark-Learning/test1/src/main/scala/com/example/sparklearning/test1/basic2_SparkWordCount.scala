package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic2_SparkWordCount {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic2_SparkWordCount")
      .master("local[*]")
      .getOrCreate()

    val data = Seq(
      "spark learning",
      "basic lesson",
      "spark spark"
    )

    import spark.implicits._
    val df = data.toDF("line")

    val result = df
      .selectExpr("explode(split(line, ' ')) as word")
      .groupBy("word")
      .count()
      .orderBy(org.apache.spark.sql.functions.desc("count"))

    result.show()
    spark.stop()
  }
}
