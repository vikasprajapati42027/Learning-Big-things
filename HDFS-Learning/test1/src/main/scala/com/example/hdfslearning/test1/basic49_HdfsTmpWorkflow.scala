package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

object basic49_HdfsTmpWorkflow {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val tmp = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/tmp_workflow/_tmpfile")
    val finalPath = new Path(tmp.getParent, "final.txt")

    fs.mkdirs(tmp.getParent)
    val out = fs.create(tmp, true)
    out.write("write safely then rename\n".getBytes("UTF-8"))
    out.close()

    fs.rename(tmp, finalPath)
    println(s"Renamed temp file to $finalPath atomically after successful write.")
  }
}
