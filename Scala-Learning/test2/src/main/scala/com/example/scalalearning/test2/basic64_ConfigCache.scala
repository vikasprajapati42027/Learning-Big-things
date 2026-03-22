package com.example.scalalearning.test2

import scala.collection.mutable

object basic64_ConfigCache {
  def main(args: Array[String]): Unit = {
    println("=== basic64: Config cache ===")
    val cache = new ConfigCache[String, String]
    cache.put("host", "localhost")
    println(cache.get("host"))
  }

  class ConfigCache[K, V] {
    private val storage = mutable.Map.empty[K, V]
    def put(key: K, value: V): Unit = storage.update(key, value)
    def get(key: K): Option[V] = storage.get(key)
  }
}
