package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic71_SparkBucketByColumns {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic71_SparkBucketByColumns").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((1, "x"), (2, "y"), (3, "x")).toDF("id", "grp")
    val tmpTable = "basic71_bucket_table"
    df.write.mode("overwrite").bucketBy(2, "grp").saveAsTable(tmpTable)
    println(s"bucketed table created -> $tmpTable (metastore required)")

    spark.stop()
  }
}
