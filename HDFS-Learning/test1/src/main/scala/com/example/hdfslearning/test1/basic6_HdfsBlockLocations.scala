package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

object basic6_HdfsBlockLocations {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val file = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/people_parquet/part-00000*")

    val globbed = fs.globStatus(file)
    if (globbed == null || globbed.isEmpty) {
      println(s"No parquet files found at $file. Run basic1_HdfsSparkDemo first.")
      return
    }
    globbed.foreach { status =>
      val blocks = fs.getFileBlockLocations(status, 0, status.getLen)
      println(s"File: ${status.getPath} len=${status.getLen}")
      blocks.foreach { b =>
        println(s"  block offset=${b.getOffset} len=${b.getLength} hosts=${b.getHosts.mkString(\",\")}")
      }
    }
  }
}
