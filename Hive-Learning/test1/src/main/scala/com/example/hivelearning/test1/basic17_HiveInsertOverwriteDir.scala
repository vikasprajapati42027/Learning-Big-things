package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic17_HiveInsertOverwriteDir {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")
    val outDir = s"$fs/tmp/hive_test1/overwrite_dir"

    val spark = SparkSession.builder()
      .appName("basic17_HiveInsertOverwriteDir")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS io_people")
    spark.sql("CREATE TABLE io_people(name STRING, age INT) STORED AS PARQUET")
    spark.sql("INSERT INTO io_people VALUES ('alice',30), ('bob',25)")

    spark.sql(s"INSERT OVERWRITE DIRECTORY '$outDir' STORED AS PARQUET SELECT * FROM io_people")
    println(s"Wrote directory: $outDir")

    spark.stop()
  }
}
