package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

object basic29_HdfsGlobStatus {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val glob = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/**")
    val matches = fs.globStatus(glob)
    println(s"Matched ${Option(matches).map(_.length).getOrElse(0)} entries:")
    Option(matches).getOrElse(Array.empty).foreach(s => println(" - " + s.getPath))
  }
}
