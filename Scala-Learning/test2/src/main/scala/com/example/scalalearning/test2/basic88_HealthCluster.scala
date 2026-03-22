package com.example.scalalearning.test2

object basic88_HealthCluster {
  def main(args: Array[String]): Unit = {
    println("=== basic88: Health cluster ===")
    statuses.foreach(println)
  }

  val statuses = List("node1:up", "node2:down")
}
