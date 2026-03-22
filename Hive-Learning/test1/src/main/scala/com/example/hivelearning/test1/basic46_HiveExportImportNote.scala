package com.example.hivelearning.test1

object basic46_HiveExportImportNote {
  def main(args: Array[String]): Unit = {
    println("Hive EXPORT/IMPORT moves table data + metadata (not ACID).")
    println("  EXPORT TABLE db.tbl TO 'hdfs:///tmp/export_tbl';")
    println("  IMPORT TABLE db.tbl_copy FROM 'hdfs:///tmp/export_tbl';")
    println("Use for migration; not intended for transactional tables.")
  }
}
