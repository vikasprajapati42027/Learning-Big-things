package com.example.scalalearning.test1

object StringCombiner {
  def main(args: Array[String]): Unit = {
    println("=== Scala String Combiner ===\n")
    val words = List("alpha", "beta", "gamma")
    println(combine(words)) // join using dash
  }

  private def combine(parts: List[String]): String = parts.mkString("-")
}
