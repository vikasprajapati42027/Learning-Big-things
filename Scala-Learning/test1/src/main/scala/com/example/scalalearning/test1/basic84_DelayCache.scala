
package com.example.scalalearning.test1

object basic84_DelayCache {
  def main(args: Array[String]): Unit = {
    println("=== Scala basic84_DelayCache ===")
    lazy val cache={println("caching");42}; println(cache); println(cache)
  }
}
