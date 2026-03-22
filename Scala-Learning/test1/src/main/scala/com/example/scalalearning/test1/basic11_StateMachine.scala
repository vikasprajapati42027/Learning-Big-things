package com.example.scalalearning.test1

object StateMachine {
  def main(args: Array[String]): Unit = {
    println("=== Scala State Machine Demo ===\n")
    demonstrateStateTransitions() // run the FSM example
    demonstrateImmutableState()   // show copy-on-write updates
  }

  // simple sealed trait so the compiler knows every PaymentState
  private sealed trait PaymentState
  // represent the basic states in the payment workflow
  private case object Initiated extends PaymentState
  private case object Authorized extends PaymentState
  private case object Captured extends PaymentState
  private case object Declined extends PaymentState

  private def demonstrateStateTransitions(): Unit = {
    println("[state transitions] modeled FSM")
    // decide the next state based on current state and event name
    def advance(state: PaymentState, event: String): PaymentState = (state, event) match {
      case (Initiated, "auth") => Authorized
      case (Authorized, "capture") => Captured
      case (_, "decline") => Declined
      case (s, _) => s
    }

    // apply each event to the state machine using scanLeft so we can print history
    val flow = List("auth", "capture").scanLeft(Initiated)((state, event) => advance(state, event))
    println(s"flow -> $flow") // show the state history for the events
    println()
  }

  private def demonstrateImmutableState(): Unit = {
    println("[immutable state] copy-on-write")
    // Ticket is immutable, copy produces a new instance with updated fields
    case class Ticket(status: String, retries: Int)
    val base = Ticket("open", 0)
    val next = base.copy(status = "processing", retries = base.retries + 1)
    println(s"base -> $base")
    println(s"next -> $next\n")
  }
}
