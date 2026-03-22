package com.example.scalalearning.test2

object basic81_StateTracer {
  def main(args: Array[String]): Unit = {
    println("=== basic81: State tracer ===")
    trace(State("start"))
  }

  case class State(name: String)
  def trace(state: State): State = {
    println(s"traced -> ${state.name}")
    state.copy(name = state.name + ":trace")
  }
}
