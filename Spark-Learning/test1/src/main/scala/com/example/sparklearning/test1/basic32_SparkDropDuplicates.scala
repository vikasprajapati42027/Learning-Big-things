package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic32_SparkDropDuplicates {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic32_SparkDropDuplicates").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((1, "a"), (1, "a"), (1, "b"), (2, "a")).toDF("id", "value")
    println("distinct on both columns")
    df.distinct().show()

    println("dropDuplicates on id only")
    df.dropDuplicates("id").show()

    spark.stop()
  }
}
