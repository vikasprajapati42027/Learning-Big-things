package com.example.scalalearning.test1

object SimpleCache {
  def main(args: Array[String]): Unit = {
    println("=== Scala Simple Cache ===")
    val cache = cacheValue("pi", math.Pi)
    println(cache)
    println(cacheValue("pi", math.Pi))
  }

  private var store = Map.empty[String, Double] // simple mutable cache

  private def cacheValue(key: String, value: Double): Map[String, Double] = {
    if (!store.contains(key)) store += key -> value // add only once
    store
  }
}
