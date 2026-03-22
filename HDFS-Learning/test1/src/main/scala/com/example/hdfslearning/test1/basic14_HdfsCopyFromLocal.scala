package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

object basic14_HdfsCopyFromLocal {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val local = new Path("README.md")
    val dest = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/copyfromlocal/readme.txt")
    fs.mkdirs(dest.getParent)

    fs.copyFromLocalFile(false, true, local, dest)
    println(s"Copied $local to $dest")
  }
}
