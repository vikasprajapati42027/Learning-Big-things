package com.example.scalalearning.test2

object basic13_RefinedTypes {
  def main(args: Array[String]): Unit = {
    println("=== basic13: Refined types ===")
    val positive = PositiveInt(5)
    println(s"positive -> ${positive.value}")
    println(s"fib -> ${factorial(positive)}")
  }

  case class PositiveInt private (value: Int)
  object PositiveInt {
    def apply(value: Int): PositiveInt =
      if (value > 0) new PositiveInt(value) else throw new IllegalArgumentException("only positive")
  }

  def factorial(n: PositiveInt): BigInt = {
    def loop(curr: Int, acc: BigInt): BigInt =
      if (curr <= 1) acc
      else loop(curr - 1, acc * curr)
    loop(n.value, 1)
  }
}
