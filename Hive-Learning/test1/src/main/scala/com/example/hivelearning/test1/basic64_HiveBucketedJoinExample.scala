package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic64_HiveBucketedJoinExample {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")

    val spark = SparkSession.builder()
      .appName("basic64_HiveBucketedJoinExample")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .config("spark.sql.sources.bucketing.enabled", "true")
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS bucket_users")
    spark.sql("DROP TABLE IF EXISTS bucket_orders")

    import spark.implicits._
    Seq((1, "alice"), (2, "bob"), (3, "carol")).toDF("user_id", "name")
      .write.mode("overwrite").bucketBy(2, "user_id").saveAsTable("bucket_users")

    Seq((1, "o1"), (1, "o2"), (2, "o3")).toDF("user_id", "order_id")
      .write.mode("overwrite").bucketBy(2, "user_id").saveAsTable("bucket_orders")

    val joined = spark.sql("SELECT /*+ BUCKET(bu, bo) */ bu.user_id, bu.name, bo.order_id FROM bucket_users bu JOIN bucket_orders bo ON bu.user_id = bo.user_id")
    joined.show()
    spark.stop()
  }
}
