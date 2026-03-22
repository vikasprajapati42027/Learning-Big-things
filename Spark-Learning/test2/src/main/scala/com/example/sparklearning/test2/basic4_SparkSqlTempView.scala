package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic4_SparkSqlTempView {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic4_SparkSqlTempView").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((1, "a"), (2, "b")).toDF("id", "val")
    df.createOrReplaceTempView("demo")
    spark.sql("select id, upper(val) as up from demo").show()

    spark.stop()
  }
}
