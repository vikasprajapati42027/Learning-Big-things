package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

object basic12_HdfsTruncate {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val file = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/truncate/demo.txt")

    fs.mkdirs(file.getParent)
    val out = fs.create(file, true)
    out.write("0123456789\n".getBytes("UTF-8"))
    out.close()

    val remaining = 5L
    val inProgress = fs.truncate(file, remaining)
    println(s"Truncate requested to length $remaining; completedImmediately=$inProgress")
  }
}
