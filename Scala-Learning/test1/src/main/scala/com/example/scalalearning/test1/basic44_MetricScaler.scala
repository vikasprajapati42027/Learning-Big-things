package com.example.scalalearning.test1

object MetricScaler {
  def main(args: Array[String]): Unit = {
    println("=== Metric Scaler ===")
    println(scale(10, 1.5))
  }

  private def scale(value: Double, factor: Double): Double = value * factor
}
