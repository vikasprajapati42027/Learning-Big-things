package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic18_HiveCTAS {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")

    val spark = SparkSession.builder()
      .appName("basic18_HiveCTAS")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS ctas_people")
    spark.sql("DROP TABLE IF EXISTS ctas_adults")

    spark.sql("CREATE TABLE ctas_people(name STRING, age INT) STORED AS PARQUET")
    spark.sql("INSERT INTO ctas_people VALUES ('alice',30), ('bob',15), ('carol',25)")

    spark.sql("CREATE TABLE ctas_adults STORED AS PARQUET AS SELECT name, age FROM ctas_people WHERE age >= 18")
    spark.sql("SELECT * FROM ctas_adults").show()

    spark.stop()
  }
}
