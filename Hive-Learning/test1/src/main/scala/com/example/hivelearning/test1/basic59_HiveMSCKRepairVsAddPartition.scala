package com.example.hivelearning.test1

object basic59_HiveMSCKRepairVsAddPartition {
  def main(args: Array[String]): Unit = {
    println("MSCK REPAIR TABLE loads partitions from filesystem (Metastore v2/v3).")
    println("ALTER TABLE tbl ADD PARTITION is explicit and faster for few partitions.")
    println("Use msck for backfill; use add partition for incremental adds in pipelines.")
  }
}
