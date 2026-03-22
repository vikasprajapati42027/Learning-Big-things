package com.example.scalalearning.test1

object EventAggregator {
  def main(args: Array[String]): Unit = {
    println("=== Scala Event Aggregator ===\n")
    val events = List("click", "click", "view")
    println(aggregate(events))
  }

  private def aggregate(events: List[String]): Map[String, Int] =
    events.groupMapReduce(identity)(_ => 1)(_ + _) // count occurrences
}
