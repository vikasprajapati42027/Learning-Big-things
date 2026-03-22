package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.udf

object basic5_SparkUdf {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic5_SparkUdf").master("local[*]").getOrCreate()
    import spark.implicits._
    val df = Seq(("Alice", 34), ("Bob", 29)).toDF("name", "age")
    val tagAdult = udf((age: Int) => if (age >= 30) "senior" else "junior")
    df.withColumn("tag", tagAdult(df("age"))).show()
    spark.stop()
  }
}
