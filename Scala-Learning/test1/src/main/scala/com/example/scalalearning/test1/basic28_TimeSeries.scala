package com.example.scalalearning.test1

object TimeSeries {
  def main(args: Array[String]): Unit = {
    println("=== Scala Time Series ===\n")
    val series = (1 to 5).map(_ * 10)
    println(s"series -> $series") // simple scaled time series
  }
}
