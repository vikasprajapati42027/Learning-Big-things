package com.example.hdfslearning.test1

object basic31_HdfsWebHdfsCurl {
  def main(args: Array[String]): Unit = {
    println("WebHDFS allows REST access to HDFS.")
    println("Example: curl -i \"http://<nn>:50070/webhdfs/v1/tmp/hdfs_test1/append/log.txt?op=OPEN&user.name=hdfs\"")
    println("Remember redirects: add -L to follow the DataNode data URL.")
  }
}
