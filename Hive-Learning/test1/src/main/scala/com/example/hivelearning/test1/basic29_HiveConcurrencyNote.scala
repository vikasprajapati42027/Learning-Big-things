package com.example.hivelearning.test1

object basic29_HiveConcurrencyNote {
  def main(args: Array[String]): Unit = {
    println("Hive concurrency/locking: transaction manager controls locks; set hive.support.concurrency=true and txn manager for ACID tables.")
    println("Check lock conflicts via SHOW LOCKS; tune hive.lock.numretries/backoff for contention.")
  }
}
