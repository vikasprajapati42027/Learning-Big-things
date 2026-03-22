package com.example.scalalearning.test2

object basic73_EventSummarizer {
  def main(args: Array[String]): Unit = {
    println("=== basic73: Event summarizer ===")
    println(summarize(List(Event("alpha"), Event("beta"), Event("alpha"))))
  }

  case class Event(tag: String)
  def summarize(events: List[Event]): Map[String, Int] =
    events.groupMapReduce(_.tag)(_ => 1)(_ + _)
}
