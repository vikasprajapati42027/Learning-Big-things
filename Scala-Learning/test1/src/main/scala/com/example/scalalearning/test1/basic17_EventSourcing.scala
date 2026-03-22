package com.example.scalalearning.test1

object EventSourcingDemo {
  def main(args: Array[String]): Unit = {
    println("=== Scala Event Sourcing ===\n")
    val events = List(Event(1, "created"), Event(1, "updated"), Event(1, "archived"))
    println(applyEvents(events))
  }

  private case class Event(id: Int, action: String)
  private case class State(id: Int, status: String)

  private def applyEvents(events: List[Event]): State =
    events.foldLeft(State(0, "empty")) { (state, event) =>
      event.action match {
        case "created" => state.copy(id = event.id, status = "created")
        case "updated" => state.copy(status = "updated")
        case "archived" => state.copy(status = "archived")
        case _ => state
      }
    }
}
