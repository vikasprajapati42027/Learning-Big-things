package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic73_SparkCheckpointDF {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic73_SparkCheckpointDF").master("local[*]").getOrCreate()
    import spark.implicits._

    spark.sparkContext.setCheckpointDir("./tmp/basic73_checkpoint")
    val df = (1 to 20).toDF("n")
    val cp = df.checkpoint()
    println(s"checkpointed count -> ${cp.count()}")

    spark.stop()
  }
}
