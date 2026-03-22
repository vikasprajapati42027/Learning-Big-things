package com.example.hdfslearning.test1

object basic36_HdfsShortCircuitNote {
  def main(args: Array[String]): Unit = {
    println("Short-circuit local reads let clients read block files directly from local DN for speed.")
    println("Ensure domain socket configured: dfs.domain.socket.path, and enable short-circuit in core-site/hdfs-site.")
    println("Verify with dfs.client.read.shortcircuit=true; fallback handles security via SASL/ACLs.")
  }
}
