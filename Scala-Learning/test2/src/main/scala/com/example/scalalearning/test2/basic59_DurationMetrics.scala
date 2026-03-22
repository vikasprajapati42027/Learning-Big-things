package com.example.scalalearning.test2

import scala.concurrent.duration._

object basic59_DurationMetrics {
  def main(args: Array[String]): Unit = {
    println("=== basic59: Duration metrics ===")
    println(toSeconds(3.minutes))
  }

  def toSeconds(duration: FiniteDuration): Long = duration.toSeconds
}
