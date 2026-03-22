package com.example.hivelearning.test1

object basic40_HiveIcebergNote {
  def main(args: Array[String]): Unit = {
    println("Hive can integrate with Iceberg via custom catalogs; Spark can read/write Iceberg tables too.")
    println("Use: CREATE TABLE prod.db.t USING iceberg LOCATION 'hdfs:///warehouse/t'; ensure iceberg runtime jars and catalogs configured.")
  }
}
