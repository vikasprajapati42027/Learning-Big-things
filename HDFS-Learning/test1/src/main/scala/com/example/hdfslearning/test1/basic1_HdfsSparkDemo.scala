package com.example.hdfslearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic1_HdfsSparkDemo {
  def main(args: Array[String]): Unit = {
    // resolve filesystem URI from env; default to local filesystem
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val output = s"$fs/tmp/hdfs_test1/people_parquet"

    val spark = SparkSession.builder()
      .appName("HdfsSparkDemo")
      .master("local[*]")
      .config("spark.hadoop.fs.defaultFS", fs)
      .getOrCreate()

    import spark.implicits._

    val people = Seq(
      ("alice", 30),
      ("bob", 17),
      ("carol", 24),
      ("dave", 15)
    ).toDF("name", "age")

    // write to Parquet in HDFS (or local fallback)
    people.write.mode("overwrite").parquet(output)
    println(s"Wrote dataset to: $output")

    // read back and do a simple aggregation
    val adults = spark.read.parquet(output).filter(col("age") >= 18)
    val count = adults.count()
    println(s"Adult count: $count")
    adults.show()

    spark.stop()
  }
}
