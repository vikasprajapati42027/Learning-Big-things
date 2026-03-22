package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

object basic45_HdfsPathExists {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val pathStr = sys.env.getOrElse("HDFS_TEST_PATH", "/tmp/hdfs_test1/people_parquet")
    val path = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + pathStr.stripSuffix("/"))
    val exists = fs.exists(path)
    println(s"Exists $path: $exists")
  }
}
