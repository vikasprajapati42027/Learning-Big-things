package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

object basic30_HdfsTail {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val file = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/append/log.txt")

    if (!fs.exists(file)) {
      println(s"$file missing. Run basic3_HdfsAppend first.")
      return
    }

    val len = fs.getFileStatus(file).getLen
    val in = fs.open(file)
    val tailLen = Math.min(100, len).toInt
    val start = len - tailLen
    in.seek(start)
    val buf = new Array[Byte](tailLen)
    val read = in.read(buf)
    println(s"Tail ($read bytes):\n" + new String(buf.take(read), "UTF-8"))
    in.close()
  }
}
