package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic22_HiveWindowFunctions {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")

    val spark = SparkSession.builder()
      .appName("basic22_HiveWindowFunctions")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS wf_sales")
    spark.sql("CREATE TABLE wf_sales(user STRING, amount DOUBLE) STORED AS PARQUET")
    spark.sql("INSERT INTO wf_sales VALUES ('alice', 10.0), ('alice', 20.0), ('bob', 5.0)")

    spark.sql(
      """SELECT user, amount,
        |       sum(amount) over(partition by user) as user_total,
        |       rank() over(order by amount desc) as amt_rank
        |FROM wf_sales""".stripMargin).show()

    spark.stop()
  }
}
