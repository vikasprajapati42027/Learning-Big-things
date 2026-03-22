package com.example.scalalearning.test1

object basic61_limitedOps {
  def main(args: Array[String]): Unit = {
    println("=== Scala basic61_limitedOps ===")
    val numbers = List(10, 20, 30, 40)
    val limited = numbers.take(2).map(_ / 10)
    println(s"limited -> $limited")
  }
}
