package com.example.scalalearning.test2

object basic39_PayloadTracer {
  def main(args: Array[String]): Unit = {
    println("=== basic39: Payload tracer ===")
    trace(List("a", "b", "c"))
  }

  def trace(payload: List[String]): Unit = {
    payload.zipWithIndex.foreach { case (value, idx) => println(s"[$idx] $value") }
  }
}
