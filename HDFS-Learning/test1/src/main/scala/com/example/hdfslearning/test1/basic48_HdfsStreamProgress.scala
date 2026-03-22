package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

object basic48_HdfsStreamProgress {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val file = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/append/log.txt")
    if (!fs.exists(file)) {
      println(s"$file missing. Run basic3_HdfsAppend first.")
      return
    }
    val in = fs.open(file)
    val total = fs.getFileStatus(file).getLen
    val buf = new Array[Byte](16)
    var read = 0L
    var n = 0
    while ({ n = in.read(buf); n } > 0) {
      read += n
      if (read % 32 == 0 || read == total) {
        println(f"Read $read/$total bytes (${read * 100.0 / total}%.1f%%)")
      }
    }
    in.close()
  }
}
