package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

object basic7_HdfsReplication {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val target = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/replication/hello.txt")

    fs.mkdirs(target.getParent)
    fs.create(target, true).write("replication demo\n".getBytes("UTF-8"))

    fs.setReplication(target, 2.toShort)
    val status = fs.getFileStatus(target)
    println(s"Set replication to 2 for ${status.getPath}, actual=${status.getReplication}")
  }
}
