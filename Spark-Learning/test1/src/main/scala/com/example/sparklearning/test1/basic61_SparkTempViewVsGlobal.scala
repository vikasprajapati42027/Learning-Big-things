package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic61_SparkTempViewVsGlobal {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic61_SparkTempViewVsGlobal").master("local[*]").getOrCreate()
    import spark.implicits._

    Seq((1, "a")).toDF("id", "val").createOrReplaceTempView("temp_view_demo")
    spark.sql("SELECT * FROM temp_view_demo").show()

    spark.stop()
  }
}
