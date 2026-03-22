package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic31_HiveBroadcastJoinSpark {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")

    val spark = SparkSession.builder()
      .appName("basic31_HiveBroadcastJoinSpark")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .config("spark.sql.autoBroadcastJoinThreshold", 10 * 1024 * 1024)
      .enableHiveSupport()
      .getOrCreate()

    import spark.implicits._
    val big = spark.range(0, 1000).toDF("id")
    val small = Seq((1, "A"), (2, "B"), (3, "C")).toDF("id", "label")

    val joined = big.join(org.apache.spark.sql.functions.broadcast(small), "id")
    joined.explain(true)
    joined.show(5)
    spark.stop()
  }
}
