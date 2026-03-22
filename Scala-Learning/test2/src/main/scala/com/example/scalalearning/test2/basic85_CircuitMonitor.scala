package com.example.scalalearning.test2

object basic85_CircuitMonitor {
  def main(args: Array[String]): Unit = {
    println("=== basic85: Circuit monitor ===")
    val monitor = new CircuitMonitor
    monitor.check(true)
    monitor.check(false)
  }

  class CircuitMonitor {
    def check(healthy: Boolean): String = if (healthy) "healthy" else "tripped"
  }
}
