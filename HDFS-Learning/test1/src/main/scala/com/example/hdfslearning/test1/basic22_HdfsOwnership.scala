package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

object basic22_HdfsOwnership {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val file = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/ownership/demo.txt")
    fs.mkdirs(file.getParent)
    fs.create(file, true).write("ownership demo\n".getBytes("UTF-8"))

    val status = fs.getFileStatus(file)
    println(s"Before chown: owner=${status.getOwner} group=${status.getGroup}")
    println("Note: setOwner requires superuser privileges on most clusters; this demo only reads current owner.")
  }
}
