package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic18_SparkSample {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic18_SparkSample").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = (1 to 20).toDF("n")
    val sample = df.sample(withReplacement = false, fraction = 0.25, seed = 42)
    sample.show()

    spark.stop()
  }
}
