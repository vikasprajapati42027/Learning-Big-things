package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic19_HiveJoinOptimizations {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")

    val spark = SparkSession.builder()
      .appName("basic19_HiveJoinOptimizations")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .config("hive.auto.convert.join", "true")
      .config("hive.mapjoin.smalltable.filesize", (20 * 1024 * 1024).toString)
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS big_table")
    spark.sql("DROP TABLE IF EXISTS small_dim")

    spark.sql("CREATE TABLE big_table(id INT, v STRING) STORED AS PARQUET")
    spark.sql("CREATE TABLE small_dim(id INT, label STRING) STORED AS PARQUET")
    spark.sql("INSERT INTO small_dim VALUES (1,'A'), (2,'B'), (3,'C')")
    spark.sql("INSERT INTO big_table SELECT id, concat('v', id) FROM range(0, 100)")

    spark.sql("EXPLAIN SELECT b.id, d.label FROM big_table b JOIN small_dim d ON b.id = d.id").show(truncate = false)
    spark.stop()
  }
}
