package com.example.hivelearning.test1

object basic27_HiveMaterializedViewNote {
  def main(args: Array[String]): Unit = {
    println("Hive materialized views support rewrite when enabled (hive.materializedview.rewriting=true).")
    println("Create with: CREATE MATERIALIZED VIEW mv_sales AS SELECT ...; then refresh manually.")
    println("Spark SQL can read MVs but rewrite support depends on configs/catalog; note this when mixing engines.")
  }
}
