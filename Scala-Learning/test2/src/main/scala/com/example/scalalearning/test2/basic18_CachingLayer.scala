package com.example.scalalearning.test2

object basic18_CachingLayer {
  def main(args: Array[String]): Unit = {
    println("=== basic18: Caching layer ===")
    val cache = new Cache[Int, String]
    cache.put(1, "one")
    println(cache.get(1))
    println(cache.getOrElse(2, "missing"))
  }

  class Cache[K, V] {
    private var map = Map.empty[K, V]
    def put(key: K, value: V): Unit = map += key -> value
    def get(key: K): Option[V] = map.get(key)
    def getOrElse(key: K, default: => V): V = map.getOrElse(key, default)
  }
}
