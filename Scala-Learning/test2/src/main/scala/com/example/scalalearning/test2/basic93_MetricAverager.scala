package com.example.scalalearning.test2

object basic93_MetricAverager {
  def main(args: Array[String]): Unit = {
    println("=== basic93: Metric averager ===")
    println(avg(List(10, 20, 30)))
  }

  def avg(values: List[Int]): Double = values.sum.toDouble / values.size
}
