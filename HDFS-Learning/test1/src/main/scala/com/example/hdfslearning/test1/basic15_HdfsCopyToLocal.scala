package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

object basic15_HdfsCopyToLocal {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val src = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/copyfromlocal/readme.txt")
    val dest = new Path("/tmp/hdfs_test1_copy_readme.txt")

    fs.copyToLocalFile(false, src, dest, true)
    println(s"Copied $src to local $dest")
  }
}
