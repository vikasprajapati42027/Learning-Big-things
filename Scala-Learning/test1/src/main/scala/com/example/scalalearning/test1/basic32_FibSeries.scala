package com.example.scalalearning.test1

object FibSeries {
  def main(args: Array[String]): Unit = {
    println("=== Fibonacci Series ===")
    println(generate(7))
  }

  private def generate(count: Int): List[Int] = {
    def loop(n: Int, a: Int, b: Int, acc: List[Int]): List[Int] =
      if (n <= 0) acc.reverse
      else loop(n - 1, b, a + b, a :: acc)
    loop(count, 0, 1, Nil)
  }
}
