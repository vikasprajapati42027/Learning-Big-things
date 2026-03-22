package com.example.hivelearning.test1

object basic45_HiveBloomFilterNote {
  def main(args: Array[String]): Unit = {
    println("For ORC tables, enable bloom filters on columns to speed predicate pushdown:")
    println("  ALTER TABLE t SET TBLPROPERTIES ('orc.bloom.filter.columns'='col1', 'orc.bloom.filter.fpp'='0.05');")
    println("Spark/Hive readers can leverage these for selective filters.")
  }
}
