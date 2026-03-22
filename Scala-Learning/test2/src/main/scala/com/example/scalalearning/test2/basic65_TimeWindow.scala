package com.example.scalalearning.test2

import scala.concurrent.duration._

object basic65_TimeWindow {
  def main(args: Array[String]): Unit = {
    println("=== basic65: Time window ===")
    println(withinWindow(5.seconds, 3.seconds))
  }

  def withinWindow(total: FiniteDuration, window: FiniteDuration): Boolean = window <= total
}
