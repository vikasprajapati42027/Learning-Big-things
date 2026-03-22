package com.example.scalalearning.test1

object basic68_lazyCache {
  lazy val value: Double = { println("materializing"); math.E }
  def main(args: Array[String]): Unit = {
    println("=== Scala basic68_lazyCache ===")
    println(value)
    println(value)
  }
}
