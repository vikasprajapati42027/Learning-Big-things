package com.example.scalalearning.test2

object basic56_Scoreboard {
  def main(args: Array[String]): Unit = {
    println("=== basic56: Scoreboard ===")
    val board = Map("alpha" -> 10, "beta" -> 15)
    println(top(board))
  }

  def top(scores: Map[String, Int]): (String, Int) = scores.maxBy(_._2)
}
