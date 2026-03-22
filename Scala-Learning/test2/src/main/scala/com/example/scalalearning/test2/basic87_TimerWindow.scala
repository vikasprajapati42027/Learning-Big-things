package com.example.scalalearning.test2

import scala.concurrent.duration._

object basic87_TimerWindow {
  def main(args: Array[String]): Unit = {
    println("=== basic87: Timer window ===")
    println(window(5.seconds, 3.seconds))
  }

  def window(total: FiniteDuration, threshold: FiniteDuration): Boolean = threshold <= total
}
