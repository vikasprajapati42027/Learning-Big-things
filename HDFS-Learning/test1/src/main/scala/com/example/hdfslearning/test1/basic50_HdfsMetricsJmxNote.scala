package com.example.hdfslearning.test1

object basic50_HdfsMetricsJmxNote {
  def main(args: Array[String]): Unit = {
    println("NameNode/DataNode expose metrics via JMX (default http port 9870/9864 /jmx).")
    println("Examples:")
    println("  curl http://nn:9870/jmx?qry=Hadoop:service=NameNode,name=NameNodeInfo")
    println("  curl http://dn:9864/jmx?qry=Hadoop:service=DataNode,name=DataNodeInfo")
    println("Use for monitoring blocks, capacity, and health programmatically.")
  }
}
