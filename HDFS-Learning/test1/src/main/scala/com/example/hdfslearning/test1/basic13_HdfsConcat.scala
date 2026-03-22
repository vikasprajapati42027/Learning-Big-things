package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

object basic13_HdfsConcat {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val base = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/concat")
    val target = new Path(base, "target.txt")
    val p1 = new Path(base, "p1.txt")
    val p2 = new Path(base, "p2.txt")

    fs.mkdirs(base)
    fs.create(target, true).write("target\n".getBytes("UTF-8"))
    fs.create(p1, true).write("part1\n".getBytes("UTF-8"))
    fs.create(p2, true).write("part2\n".getBytes("UTF-8"))

    fs.concat(target, Array(p1, p2))
    println(s"Concatenated $p1 and $p2 into $target (source files removed).")
  }
}
