package com.example.scalalearning.test2

object basic37_CircuitBreaker {
  def main(args: Array[String]): Unit = {
    println("=== basic37: Circuit breaker ===")
    val breaker = new CircuitBreaker
    println(breaker.run(() => "ok"))
    breaker.fail()
    println(breaker.run(() => "should short-circuit"))
  }

  class CircuitBreaker {
    private var open = false
    def fail(): Unit = open = true
    def run[T](block: () => T): Option[T] =
      if (open) None
      else Some(block())
  }
}
