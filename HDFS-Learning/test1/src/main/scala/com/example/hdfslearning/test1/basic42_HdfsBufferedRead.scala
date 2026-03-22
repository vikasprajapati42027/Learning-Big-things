package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

object basic42_HdfsBufferedRead {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val file = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/append/log.txt")
    if (!fs.exists(file)) {
      println(s"$file missing. Run basic3_HdfsAppend first.")
      return
    }
    val bufferSize = 128 * 1024
    val in = fs.open(file, bufferSize)
    val data = in.readUTF() // reads first UTF segment
    println(s"Read first UTF string with buffer=$bufferSize bytes: $data")
    in.close()
  }
}
