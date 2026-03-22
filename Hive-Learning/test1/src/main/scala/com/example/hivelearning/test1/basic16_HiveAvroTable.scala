package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic16_HiveAvroTable {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")

    val spark = SparkSession.builder()
      .appName("basic16_HiveAvroTable")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS avro_users")

    spark.sql(
      """CREATE TABLE avro_users
        |ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.avro.AvroSerDe'
        |STORED AS AVRO
        |TBLPROPERTIES ('avro.schema.literal'='{
        |  "type": "record",
        |  "name": "user",
        |  "fields": [
        |    {"name":"name","type":"string"},
        |    {"name":"age","type":"int"}
        |  ]}')""".stripMargin)

    spark.sql("INSERT INTO avro_users VALUES ('alice',30), ('bob',25)")
    spark.sql("SELECT * FROM avro_users").show()

    spark.stop()
  }
}
