package com.example.scalalearning.test2

object basic33_EventRouter {
  def main(args: Array[String]): Unit = {
    println("=== basic33: Event router ===")
    val router = new EventRouter
    router.route(Event("start", "system"))
    router.route(Event("stop", "system"))
  }

  case class Event(name: String, source: String)

  class EventRouter {
    def route(event: Event): Unit = event.name match {
      case "start" => println(s"start from ${event.source}")
      case "stop" => println(s"stop from ${event.source}")
      case other => println(s"unknown -> $other")
    }
  }
}
