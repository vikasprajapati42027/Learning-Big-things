package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic13_HiveCompressTable {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")

    val spark = SparkSession.builder()
      .appName("basic13_HiveCompressTable")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .config("hive.exec.compress.output", "true")
      .config("mapred.output.compression.codec", "org.apache.hadoop.io.compress.SnappyCodec")
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS snappy_people")
    spark.sql("CREATE TABLE snappy_people(name STRING, age INT) STORED AS PARQUET")
    spark.sql("INSERT INTO snappy_people VALUES ('alice',30), ('bob',25)")

    spark.sql("SELECT * FROM snappy_people").show()
    spark.stop()
  }
}
