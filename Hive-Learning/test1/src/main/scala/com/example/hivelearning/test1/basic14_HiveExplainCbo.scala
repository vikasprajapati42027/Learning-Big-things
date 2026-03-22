package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic14_HiveExplainCbo {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")

    val spark = SparkSession.builder()
      .appName("basic14_HiveExplainCbo")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("SET hive.cbo.enable=true")
    spark.sql("SET hive.compute.query.using.stats=true")

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS cbo_people")
    spark.sql("CREATE TABLE cbo_people(name STRING, age INT) STORED AS PARQUET")
    spark.sql("INSERT INTO cbo_people VALUES ('alice',30), ('bob',25), ('carol',40)")
    spark.sql("ANALYZE TABLE cbo_people COMPUTE STATISTICS FOR COLUMNS name, age")

    spark.sql("EXPLAIN EXTENDED SELECT * FROM cbo_people WHERE age > 30").show(truncate = false)
    spark.stop()
  }
}
