package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic99_SparkDatasetCheckpoint {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic99_SparkDatasetCheckpoint").master("local[*]").getOrCreate()
    import spark.implicits._

    spark.sparkContext.setCheckpointDir("./tmp/basic99_checkpoint")
    val ds = (1 to 5).toDS()
    val cp = ds.checkpoint()
    println(s"checkpoint count -> ${cp.count()}")

    spark.stop()
  }
}
