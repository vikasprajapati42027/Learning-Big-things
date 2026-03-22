package com.example.scalalearning.test1

import scala.util.Random

object RandomWalk {
  def main(args: Array[String]): Unit = {
    println("=== Scala Random Walk ===\n")
    println(s"walk -> ${walk(5)}") // random result after 5 steps
  }

  private def walk(steps: Int, position: Int = 0): Int =
    if (steps == 0) position else walk(steps - 1, position + (if (Random.nextBoolean()) 1 else -1))
}
