package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

object basic9_HdfsSnapshotsInfo {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val dir = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/snapdir")
    fs.mkdirs(dir)

    println(s"Snapshot capability needs to be enabled by admin: hdfs dfsadmin -allowSnapshot $dir")
    println("This sample just ensures the directory exists and reminds steps:")
    println("  1) hdfs dfsadmin -allowSnapshot /tmp/hdfs_test1/snapdir")
    println("  2) hdfs dfs -createSnapshot /tmp/hdfs_test1/snapdir s1")
    println("  3) hdfs dfs -ls /tmp/hdfs_test1/snapdir/.snapshot")
  }
}
