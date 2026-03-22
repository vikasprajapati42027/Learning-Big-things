package com.example.scalalearning.test2

import scala.concurrent.duration._

object basic96_TimeAggregator {
  def main(args: Array[String]): Unit = {
    println("=== basic96: Time aggregator ===")
    println(collect(1.second, 2.seconds))
  }

  def collect(d1: FiniteDuration, d2: FiniteDuration): FiniteDuration = d1 + d2
}
