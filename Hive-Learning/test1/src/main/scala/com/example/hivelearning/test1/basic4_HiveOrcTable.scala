package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic4_HiveOrcTable {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")

    val spark = SparkSession.builder()
      .appName("basic4_HiveOrcTable")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS orc_products")

    spark.sql(
      """CREATE TABLE orc_products(
        |  sku STRING,
        |  price DOUBLE
        |) STORED AS ORC
        |""".stripMargin)

    spark.sql("INSERT INTO orc_products VALUES ('sku1', 10.0), ('sku2', 15.5)")
    spark.sql("SELECT * FROM orc_products").show()

    spark.stop()
  }
}
