package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic11_HiveAcidMerge {
  def main(args: Array[String]): Unit = {
    val fs = sys.env.getOrElse("HDFS_DEMO_FS", "file:///")
    val warehouse = sys.env.getOrElse("HIVE_WAREHOUSE", s"$fs/user/hive/warehouse")

    val spark = SparkSession.builder()
      .appName("basic11_HiveAcidMerge")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", warehouse)
      .config("spark.hadoop.fs.defaultFS", fs)
      .config("spark.sql.hive.convertMetastoreParquet", "false") // needed for ACID in some setups
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("DROP TABLE IF EXISTS acid_people")
    spark.sql("CREATE TABLE acid_people(name STRING, age INT) STORED AS ORC TBLPROPERTIES ('transactional'='true')")

    spark.sql("INSERT INTO acid_people VALUES ('alice',30), ('bob',25)")

    val updates = Seq(("bob", 26), ("carol", 22))
    val tmp = spark.createDataFrame(updates).toDF("name", "age")
    tmp.createOrReplaceTempView("updates")

    spark.sql(
      """MERGE INTO acid_people t
        |USING updates u
        |ON t.name = u.name
        |WHEN MATCHED THEN UPDATE SET age = u.age
        |WHEN NOT MATCHED THEN INSERT (name, age) VALUES (u.name, u.age)
        |""".stripMargin)

    spark.sql("SELECT * FROM acid_people").show()
    spark.stop()
  }
}
