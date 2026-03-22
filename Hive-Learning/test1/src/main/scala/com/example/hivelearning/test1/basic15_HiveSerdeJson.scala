package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic15_HiveSerdeJson {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")

    val spark = SparkSession.builder()
      .appName("basic15_HiveSerdeJson")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS json_events")

    spark.sql(
      """CREATE TABLE json_events(
        |  user STRING,
        |  action STRING
        |) ROW FORMAT SERDE 'org.apache.hive.hcatalog.data.JsonSerDe'
        |STORED AS TEXTFILE""".stripMargin)

    spark.sql("INSERT INTO json_events VALUES ('alice','click'), ('bob','view')")
    spark.sql("SELECT * FROM json_events").show()

    spark.stop()
  }
}
