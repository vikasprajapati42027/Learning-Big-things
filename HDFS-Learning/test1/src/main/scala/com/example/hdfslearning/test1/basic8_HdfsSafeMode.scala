package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem

object basic8_HdfsSafeMode {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)

    val isSafe = fs.setSafeMode(org.apache.hadoop.hdfs.protocol.HdfsConstants.SafeModeAction.SAFEMODE_GET)
    println(s"SafeMode status: $isSafe")
    println("Note: entering/exiting safemode requires admin; this demo only reads status.")
  }
}
