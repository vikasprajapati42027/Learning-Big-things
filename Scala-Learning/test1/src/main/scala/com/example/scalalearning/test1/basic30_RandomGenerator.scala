package com.example.scalalearning.test1

import scala.util.Random

object RandomGenerator {
  def main(args: Array[String]): Unit = {
    println("=== Scala Random Generator ===\n")
    println(s"random -> ${Random.nextInt(100)}") // print random number under 100
  }
}
