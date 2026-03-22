package com.example.scalalearning.test1

object RangeSummary {
  def main(args: Array[String]): Unit = {
    println("=== Range Summary ===")
    println(summary(1 to 5))
  }

  private def summary(range: Range): (Int, Int) = (range.min, range.max)
}
