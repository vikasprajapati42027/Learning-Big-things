package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.udf

object basic8_HiveUdf {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")

    val spark = SparkSession.builder()
      .appName("basic8_HiveUdf")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS udf_people")
    spark.sql("CREATE TABLE udf_people(name STRING, age INT) STORED AS PARQUET")
    spark.sql("INSERT INTO udf_people VALUES ('alice', 30), ('bob', 17)")

    val up = udf((s: String) => s.toUpperCase)
    spark.udf.register("to_upper_scala", up)

    spark.sql("SELECT to_upper_scala(name) as NAME_UPPER, age FROM udf_people").show()
    spark.stop()
  }
}
