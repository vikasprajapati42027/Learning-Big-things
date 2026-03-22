package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

object basic47_HdfsChecksumCompare {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val p1 = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/append/log.txt")
    val p2 = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/append/log_copy.txt")

    if (!fs.exists(p1)) {
      println(s"$p1 missing. Run basic3_HdfsAppend first.")
      return
    }
    fs.copyToLocalFile(false, p1, new Path("/tmp/log_copy_local.txt"), true)
    fs.copyFromLocalFile(new Path("/tmp/log_copy_local.txt"), p2)

    val c1 = fs.getFileChecksum(p1)
    val c2 = fs.getFileChecksum(p2)
    println(s"Checksum p1=$c1 p2=$c2 equal=${c1 == c2}")
  }
}
