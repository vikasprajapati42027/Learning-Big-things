package com.example.scalalearning.test1

object basic62_sealedFlow {
  sealed trait Status
  case object Idle extends Status
  case object Running extends Status
  case object Done extends Status

  def main(args: Array[String]): Unit = {
    println("=== Scala basic62_sealedFlow ===")
    val current = Running
    println(describe(current))
  }

  private def describe(status: Status): String = status match {
    case Idle    => "waiting"
    case Running => "running"
    case Done    => "done"
  }
}
