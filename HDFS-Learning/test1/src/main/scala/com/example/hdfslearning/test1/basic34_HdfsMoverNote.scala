package com.example.hdfslearning.test1

object basic34_HdfsMoverNote {
  def main(args: Array[String]): Unit = {
    println("HDFS Mover relocates blocks to satisfy storage policies (e.g., HOT, COLD, ONE_SSD).")
    println("Usage: hdfs mover -p /path")
    println("Set storage policy: hdfs storagepolicies -setStoragePolicy -path /path -policy COLD")
  }
}
