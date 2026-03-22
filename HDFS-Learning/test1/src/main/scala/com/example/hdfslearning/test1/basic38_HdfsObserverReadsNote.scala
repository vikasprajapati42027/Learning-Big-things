package com.example.hdfslearning.test1

object basic38_HdfsObserverReadsNote {
  def main(args: Array[String]): Unit = {
    println("Observer NameNodes (RO) offload read traffic in HA clusters.")
    println("Client config: fs.client.failover.proxy.provider supports observer; set dfs.client.failover.max.attempts, and enable observer reads.")
    println("Use for read-heavy workloads; writes still go to Active NN.")
  }
}
