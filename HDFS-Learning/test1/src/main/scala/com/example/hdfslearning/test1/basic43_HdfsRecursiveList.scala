package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path, RemoteIterator, LocatedFileStatus}

object basic43_HdfsRecursiveList {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val root = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1")
    val iter: RemoteIterator[LocatedFileStatus] = fs.listFiles(root, true)
    println(s"Recursive list under $root:")
    while (iter.hasNext) {
      val st = iter.next()
      println(s" - ${st.getPath} size=${st.getLen}")
    }
  }
}
