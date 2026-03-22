package com.example.hdfslearning.test1

object basic40_HdfsRouterFederationNote {
  def main(args: Array[String]): Unit = {
    println("Router-based Federation provides a unified namespace across federated NameNodes.")
    println("Routers forward requests to subclusters; mount table defines path-to-cluster mapping.")
    println("Clients use a single logical URI; good for horizontal scaling of namespace and throughput.")
  }
}
