package com.example.scalalearning.test1

object NumFilter {
  def main(args: Array[String]): Unit = {
    println("=== Scala Number Filter ===")
    println(filter(List(1,2,3,4,5))) // keep odd numbers
  }

  private def filter(nums: List[Int]): List[Int] = nums.filter(_ % 2 == 1)
}
