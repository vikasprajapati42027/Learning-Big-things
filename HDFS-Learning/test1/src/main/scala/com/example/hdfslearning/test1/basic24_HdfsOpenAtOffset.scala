package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

object basic24_HdfsOpenAtOffset {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val file = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/append/log.txt")

    if (!fs.exists(file)) {
      println(s"$file missing. Run basic3_HdfsAppend first.")
      return
    }

    val in = fs.open(file, 4096)
    val len = fs.getFileStatus(file).getLen
    val start = Math.max(0, len - 20)
    in.seek(start)
    val bytes = new Array[Byte](Math.min(20, len).toInt)
    val read = in.read(bytes)
    println(s"Last $read bytes from offset $start: " + new String(bytes.take(read), "UTF-8"))
    in.close()
  }
}
