package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic1_HiveSparkDemo {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")
    val output = s"$fs/tmp/hive_test1/people_out"

    val spark = SparkSession.builder()
      .appName("basic1_HiveSparkDemo")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")

    spark.sql(
      """CREATE TABLE IF NOT EXISTS people (name STRING, age INT)
        |STORED AS PARQUET""".stripMargin)

    // insert sample rows (overwrite for idempotency using temp view)
    val data = Seq(("alice", 30), ("bob", 17), ("carol", 24), ("dave", 15))
    spark.createDataFrame(data).toDF("name", "age").createOrReplaceTempView("people_tmp")
    spark.sql("TRUNCATE TABLE people")
    spark.sql("INSERT INTO people SELECT name, age FROM people_tmp")

    val adults = spark.sql("SELECT name, age FROM people WHERE age >= 18 ORDER BY age")
    adults.show()

    adults.write.mode("overwrite").parquet(output)
    println(s"Wrote result to: $output")

    spark.stop()
  }
}
