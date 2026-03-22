package com.example.hivelearning.test1

object basic50_HiveSessionStateNote {
  def main(args: Array[String]): Unit = {
    println("Spark’s Hive support uses a Hive-compatible SessionState/Catalog for SQL interoperability.")
    println("Configs: spark.sql.catalogImplementation=hive, spark.sql.warehouse.dir, spark.hadoop.fs.defaultFS.")
    println("Know which catalog you target when mixing Hive tables and Spark data sources.")
  }
}
