package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic24_HiveVectorizedOrc {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")

    val spark = SparkSession.builder()
      .appName("basic24_HiveVectorizedOrc")
      .master("local[*]")
      .config("spark.sql.orc.filterPushdown", "true")
      .config("spark.sql.orc.enableVectorizedReader", "true")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS orc_vec")
    spark.sql("CREATE TABLE orc_vec(id INT, v STRING) STORED AS ORC")
    spark.sql("INSERT INTO orc_vec VALUES (1,'a'), (2,'b'), (3,'c')")

    spark.sql("SELECT * FROM orc_vec WHERE id < 3").show()
    spark.stop()
  }
}
