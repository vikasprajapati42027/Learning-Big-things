package com.example.scalalearning.test1

object EventDispatcher {
  def main(args: Array[String]): Unit = {
    println("=== Scala Event Dispatcher ===")
    val handlers = Map("ping" -> (() => println("pong"))) // map events to functions
    dispatch(handlers,"ping")
  }

  private def dispatch(handlers: Map[String, () => Unit], event: String): Unit =
    handlers.get(event).foreach(f=>f()) // call handler if exists
}
