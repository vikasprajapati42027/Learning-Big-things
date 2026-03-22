package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

object basic21_HdfsExtendedAttributes {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val file = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/xattr/demo.txt")

    fs.mkdirs(file.getParent)
    fs.create(file, true).write("xattr demo\n".getBytes("UTF-8"))

    val key = "user.demo"
    val value = "hello-xattr".getBytes("UTF-8")
    fs.setXAttr(file, key, value)

    val attrs = fs.listXAttrs(file)
    println(s"XAttrs on $file: ${attrs}")
    val stored = fs.getXAttr(file, key)
    println(s"Value of $key = ${new String(stored, "UTF-8")}")
  }
}
