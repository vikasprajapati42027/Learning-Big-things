package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic23_HiveSkewHint {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")

    val spark = SparkSession.builder()
      .appName("basic23_HiveSkewHint")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS skew_t")
    spark.sql("CREATE TABLE skew_t(k INT, v STRING) STORED AS PARQUET")
    spark.sql("INSERT INTO skew_t SELECT 1, 'x' FROM range(0, 100) UNION ALL SELECT 2, 'y' FROM range(0, 5)")

    spark.sql("EXPLAIN SELECT /*+ SKEW(k) */ k, count(*) FROM skew_t GROUP BY k").show(truncate = false)
    spark.stop()
  }
}
