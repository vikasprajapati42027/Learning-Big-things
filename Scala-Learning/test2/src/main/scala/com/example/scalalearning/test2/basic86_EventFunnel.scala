package com.example.scalalearning.test2

object basic86_EventFunnel {
  def main(args: Array[String]): Unit = {
    println("=== basic86: Event funnel ===")
    println(funnel(List(1, 2, 3)))
  }

  def funnel(events: List[Int]): Int = events.filter(_ % 2 == 1).sum
}
