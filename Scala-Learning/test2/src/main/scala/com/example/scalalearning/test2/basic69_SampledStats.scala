package com.example.scalalearning.test2

object basic69_SampledStats {
  def main(args: Array[String]): Unit = {
    println("=== basic69: Sampled stats ===")
    println(stats(List(1, 2, 3)))
  }

  def stats(values: List[Int]): (Int, Int) = (values.min, values.max)
}
