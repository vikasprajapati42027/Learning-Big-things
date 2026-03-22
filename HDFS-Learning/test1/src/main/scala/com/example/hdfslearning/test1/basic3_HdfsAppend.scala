package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FSDataOutputStream, FileSystem, Path}

object basic3_HdfsAppend {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val base = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/append")
    val file = new Path(base, "log.txt")

    fs.mkdirs(base)

    // create or append
    val out: FSDataOutputStream = if (fs.exists(file)) fs.append(file) else fs.create(file, true)
    out.writeBytes(s"line at ${System.currentTimeMillis()}\n")
    out.close()

    println(s"Wrote/append to $file")
  }
}
