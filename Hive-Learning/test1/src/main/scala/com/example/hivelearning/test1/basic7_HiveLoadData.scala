package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession
import java.nio.file.{Files, Paths}

object basic7_HiveLoadData {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")

    val spark = SparkSession.builder()
      .appName("basic7_HiveLoadData")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS text_people")
    spark.sql("CREATE TABLE text_people(name STRING, age INT) ROW FORMAT DELIMITED FIELDS TERMINATED BY ',' STORED AS TEXTFILE")

    val tmpFile = Paths.get("text_people.csv")
    val content = "alice,30\nbob,17\ncarol,24\n"
    Files.write(tmpFile, content.getBytes("UTF-8"))

    spark.sql(s"LOAD DATA LOCAL INPATH '${tmpFile.toAbsolutePath.toString}' OVERWRITE INTO TABLE text_people")
    spark.sql("SELECT * FROM text_people").show()

    spark.stop()
  }
}
