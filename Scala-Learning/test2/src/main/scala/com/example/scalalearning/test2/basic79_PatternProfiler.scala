package com.example.scalalearning.test2

object basic79_PatternProfiler {
  def main(args: Array[String]): Unit = {
    println("=== basic79: Pattern profiler ===")
    println(count("aaabb"))
  }

  def count(input: String): Map[Char, Int] =
    input.groupMapReduce(identity)(_ => 1)(_ + _)
}
