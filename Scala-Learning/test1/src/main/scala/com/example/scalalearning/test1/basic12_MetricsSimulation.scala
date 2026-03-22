package com.example.scalalearning.test1

object MetricsSimulation {
  def main(args: Array[String]): Unit = {
    println("=== Scala Metrics Simulation ===\n")
    demonstrateCounter()
    demonstrateHistogram()
    demonstrateSlidingRate()
  }

  private def demonstrateCounter(): Unit = {
    println("[counter] atomic increments")
    var counter = 0
    def inc(value: Int): Unit = counter += value
    inc(5)
    inc(3)
    println(s"counter -> $counter")
    println()
  }

  private def demonstrateHistogram(): Unit = {
    println("[histogram] bin sort")
    val samples = List(1.2, 2.5, 3.1, 2.9, 1.8, 3.7)
    val bins = samples.grouped(2).zipWithIndex.map { case (group, idx) => s"bin$idx -> ${group.sum / group.size}" }
    bins.foreach(println)
    println()
  }

  private def demonstrateSlidingRate(): Unit = {
    println("[sliding rate] moving window")
    val events = (1 to 20).toList
    val ratePerWindow = events.sliding(5).map(window => window.size.toDouble / 5).toList
    println(s"rate/window -> $ratePerWindow")
    println()
  }
}
