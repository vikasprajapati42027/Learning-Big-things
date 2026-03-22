package com.example.hivelearning.test1

object basic37_HiveOrcAcidCompactionNote {
  def main(args: Array[String]): Unit = {
    println("For ORC ACID tables, minor/major compaction reduces delta files.")
    println("Use: ALTER TABLE <tbl> COMPACT 'minor'; and monitor SHOW COMPACTIONS.")
    println("Spark writes to ACID tables need appropriate configs (hive.fetch.task.conversion=none, etc.).")
  }
}
