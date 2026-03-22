package com.example.scalalearning.test1

object basic69_aggregator {
  def main(args: Array[String]): Unit = {
    println("=== Scala basic69_aggregator ===")
    println(aggregate(List(1,2,3)))
  }

  private def aggregate(nums: List[Int]): Int = nums.sum
}
