package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic38_HiveSchemaEvolutionOrc {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")

    val spark = SparkSession.builder()
      .appName("basic38_HiveSchemaEvolutionOrc")
      .master("local[*]")
      .config("spark.sql.orc.impl", "native")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS orc_schema_evo")
    spark.sql("CREATE TABLE orc_schema_evo(name STRING) STORED AS ORC")
    spark.sql("INSERT INTO orc_schema_evo VALUES ('alice')")

    spark.sql("ALTER TABLE orc_schema_evo ADD COLUMNS (age INT)")
    spark.sql("INSERT INTO orc_schema_evo VALUES ('bob', 30)")

    spark.sql("SELECT * FROM orc_schema_evo").show()
    spark.stop()
  }
}
