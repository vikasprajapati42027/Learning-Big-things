package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic35_HiveSerdeRegex {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")

    val spark = SparkSession.builder()
      .appName("basic35_HiveSerdeRegex")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS regex_log")

    spark.sql(
      """CREATE TABLE regex_log (
        |  ts STRING,
        |  level STRING,
        |  msg STRING
        |) ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.RegexSerDe'
        |WITH SERDEPROPERTIES (
        |  'input.regex'='^(\\S+)\\s+(\\S+)\\s+(.*)$'
        |)
        |STORED AS TEXTFILE""".stripMargin)

    spark.sql("INSERT INTO regex_log VALUES ('2024-01-01T00:00:00Z','INFO','hello'), ('2024-01-01T01:00:00Z','WARN','warn msg')")
    spark.sql("SELECT * FROM regex_log").show()
    spark.stop()
  }
}
