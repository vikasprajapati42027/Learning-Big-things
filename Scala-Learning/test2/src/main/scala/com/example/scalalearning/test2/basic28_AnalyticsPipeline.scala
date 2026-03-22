package com.example.scalalearning.test2

object basic28_AnalyticsPipeline {
  def main(args: Array[String]): Unit = {
    println("=== basic28: Analytics pipeline ===")
    val events = Seq(Event("click", 1), Event("purchase", 5))
    val score = pipeline(events)
    println(s"score -> $score")
  }

  case class Event(name: String, weight: Int)

  def pipeline(events: Seq[Event]): Int =
    events.foldLeft(0)((acc, event) => acc + event.weight * multiplier(event))

  def multiplier(event: Event): Int = if (event.name == "purchase") 10 else 1
}
