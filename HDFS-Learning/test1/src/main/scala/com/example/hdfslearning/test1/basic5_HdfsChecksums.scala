package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

object basic5_HdfsChecksums {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val file = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/append/log.txt")

    if (!fs.exists(file)) {
      println(s"$file not found. Run basic3_HdfsAppend first.")
      return
    }
    val sum = fs.getFileChecksum(file)
    println(s"Checksum for $file: $sum")
  }
}
