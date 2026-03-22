package com.example.scalalearning.test1

object basic66_eventTimeline {
  case class Timeline(event: String, timestamp: Long)
  def main(args: Array[String]): Unit = {
    println("=== Scala basic66_eventTimeline ===")
    val events = List(Timeline("start", 0), Timeline("end", 100))
    println(events.map(_.event))
  }
}
