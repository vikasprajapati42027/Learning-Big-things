package com.example.hdfslearning.test1

object basic32_HdfsHttpFsNote {
  def main(args: Array[String]): Unit = {
    println("HttpFS is a stateless REST gateway for HDFS, good for DMZ access.")
    println("Start: hadoop httpfs start (check httpfs-site.xml).")
    println("API mirrors WebHDFS, but traffic goes via the HttpFS host, not DataNodes directly.")
  }
}
