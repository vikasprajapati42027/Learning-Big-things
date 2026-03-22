package com.example.scalalearning.test1

import scala.util.Random

object RandomSampler {
  def main(args: Array[String]): Unit = {
    println("=== Random Sampler ===")
    println(sample(List(1,2,3,4)))
  }

  private def sample(values: List[Int]): Int = values(Random.nextInt(values.size))
}
