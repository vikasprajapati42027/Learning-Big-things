package com.example.scalalearning.test2

object basic63_StateAccumulator {
  def main(args: Array[String]): Unit = {
    println("=== basic63: State accumulator ===")
    println(accumulate(1 to 5))
  }

  def accumulate(range: Range): Int = range.sum
}
