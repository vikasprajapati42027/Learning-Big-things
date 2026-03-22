package com.example.hivelearning.test1

object basic20_HiveTxnCleanupNote {
  def main(args: Array[String]): Unit = {
    println("For transactional (ACID) tables, run compaction/cleanup:")
    println("  ALTER TABLE <tbl> COMPACT 'major';")
    println("  SHOW COMPACTIONS;")
    println("Configure hive.compactor.initiator.on + worker + txn timeout to avoid txn build-up.")
  }
}
