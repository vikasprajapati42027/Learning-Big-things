package com.example.scalalearning.test2

object basic72_PolarityDetector {
  def main(args: Array[String]): Unit = {
    println("=== basic72: Polarity detector ===")
    println(score("happy"))
  }

  def score(message: String): Int = if (message.contains("happy")) 1 else -1
}
