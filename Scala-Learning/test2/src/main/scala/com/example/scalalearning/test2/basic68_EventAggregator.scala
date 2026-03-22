package com.example.scalalearning.test2

object basic68_EventAggregator {
  def main(args: Array[String]): Unit = {
    println("=== basic68: Event aggregator ===")
    println(aggregate(List("a", "b", "c")))
  }

  def aggregate(events: List[String]): String = events.mkString("|")
}
