package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic21_HiveLateralViewExplode {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")

    val spark = SparkSession.builder()
      .appName("basic21_HiveLateralViewExplode")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS lv_events")
    spark.sql("CREATE TABLE lv_events(user STRING, actions ARRAY<STRING>) STORED AS PARQUET")
    spark.sql("INSERT INTO lv_events VALUES ('alice', array('click','view')), ('bob', array('view'))")

    spark.sql(
      """SELECT user, action
        |FROM lv_events
        |LATERAL VIEW explode(actions) e as action""".stripMargin).show()

    spark.stop()
  }
}
