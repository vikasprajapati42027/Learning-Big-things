package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

object basic11_HdfsRenameMove {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val base = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/rename")
    val src = new Path(base, "src.txt")
    val dst = new Path(base, "moved/dst.txt")

    fs.mkdirs(base)
    fs.create(src, true).write("rename demo\n".getBytes("UTF-8"))
    fs.mkdirs(dst.getParent)
    val ok = fs.rename(src, dst)
    println(s"Rename result: $ok (from $src to $dst)")
  }
}
