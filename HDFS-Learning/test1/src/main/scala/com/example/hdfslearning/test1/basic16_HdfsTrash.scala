package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path, Trash}

object basic16_HdfsTrash {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val trash = new Trash(conf)
    val file = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/trash/demo.txt")

    fs.mkdirs(file.getParent)
    fs.create(file, true).write("trash me\n".getBytes("UTF-8"))

    val moved = trash.moveToTrash(file)
    println(s"Moved to trash=$moved; check ~/.Trash or /user/<name>/.Trash")
  }
}
