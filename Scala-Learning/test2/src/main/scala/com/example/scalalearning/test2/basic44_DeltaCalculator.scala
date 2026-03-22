package com.example.scalalearning.test2

object basic44_DeltaCalculator {
  def main(args: Array[String]): Unit = {
    println("=== basic44: Delta calculator ===")
    println(delta(10, 4))
  }

  def delta(current: Int, previous: Int): Int = current - previous
}
