package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic3_HiveBucketedTable {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")

    val spark = SparkSession.builder()
      .appName("basic3_HiveBucketedTable")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .config("spark.sql.sources.bucketing.enabled", "true")
      .enableHiveSupport()
      .getOrCreate()

    import spark.implicits._

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS bucketed_users")

    val users = Seq((1, "alice"), (2, "bob"), (3, "carol"), (4, "dave"))
      .toDF("id", "name")

    users.write
      .format("parquet")
      .mode("overwrite")
      .bucketBy(2, "id")
      .sortBy("id")
      .saveAsTable("bucketed_users")

    spark.sql("SELECT * FROM bucketed_users ORDER BY id").show()
    spark.stop()
  }
}
