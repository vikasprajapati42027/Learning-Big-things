package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

object basic41_HdfsSetTimes {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val file = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/times/demo.txt")
    fs.mkdirs(file.getParent)
    fs.create(file, true).write("timestamps\n".getBytes("UTF-8"))

    val now = System.currentTimeMillis()
    fs.setTimes(file, now, now)
    val st = fs.getFileStatus(file)
    println(s"Set times on $file -> mtime=${st.getModificationTime} atime=${st.getAccessTime}")
  }
}
