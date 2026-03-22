package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

object basic44_HdfsDeleteRecursive {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val target = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/to_delete")
    fs.mkdirs(target)
    fs.create(new Path(target, "file.txt"), true).write("delete me\n".getBytes("UTF-8"))

    val deleted = fs.delete(target, true)
    println(s"Recursive delete of $target -> $deleted")
  }
}
