package com.example.hdfslearning.test1

object basic20_HdfsErasureCodingNote {
  def main(args: Array[String]): Unit = {
    println("Erasure Coding reduces storage overhead vs replication; configure per directory (admin).")
    println("Example: hdfs ec -setPolicy -path /cold -policy RS-6-3-1024k")
    println("Check: hdfs ec -getPolicy -path /cold")
    println("Use for cold data; trades CPU for lower space, not ideal for hot random writes.")
  }
}
