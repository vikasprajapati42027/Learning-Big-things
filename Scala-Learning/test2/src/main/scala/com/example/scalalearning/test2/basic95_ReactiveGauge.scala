package com.example.scalalearning.test2

object basic95_ReactiveGauge {
  def main(args: Array[String]): Unit = {
    println("=== basic95: Reactive gauge ===")
    println(Indicator(100).read())
  }

  case class Indicator(value: Int) {
    def read(): Int = value
  }
}
