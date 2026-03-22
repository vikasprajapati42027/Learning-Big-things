package com.example.scalalearning.test1

object ErrorCounts {
  def main(args: Array[String]): Unit = {
    println("=== Error Counts ===")
    println(count(List("error", "info", "error")))
  }

  private def count(events: List[String]): Int = events.count(_ == "error")
}
