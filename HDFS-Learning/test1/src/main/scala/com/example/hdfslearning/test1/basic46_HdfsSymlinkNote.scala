package com.example.hdfslearning.test1

object basic46_HdfsSymlinkNote {
  def main(args: Array[String]): Unit = {
    println("HDFS supports symlinks but many clusters disable them (dfs.client.read.shortcircuit must allow).")
    println("CLI example (if enabled): hdfs dfs -ln -s /path/target /path/link")
    println("Check dfs.client.read.shortcircuit and dfs.client.symlink.* configs; expect limited support in tools.")
  }
}
