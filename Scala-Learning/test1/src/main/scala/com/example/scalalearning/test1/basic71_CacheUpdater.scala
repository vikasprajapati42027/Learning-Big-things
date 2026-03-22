package com.example.scalalearning.test1

object basic71_CacheUpdater {
  def main(args: Array[String]): Unit = {
    println("=== Scala basic71_CacheUpdater ===")
    val cache = Map("k" -> 1)
    println(cache.updated("k", cache("k") + 1))
  }
}
