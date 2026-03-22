package com.example.scalalearning.test2

object basic15_EventCollector {
  def main(args: Array[String]): Unit = {
    println("=== basic15: Event collector ===")
    val collector = new EventCollector
    collector.record("tick")
    collector.record("tock")
    println(collector.summary)
  }

  class EventCollector {
    private var events = Vector.empty[String]
    def record(event: String): Unit = events :+= event
    def summary: String = events.mkString("|")
  }
}
