package com.example.scalalearning.test1

import scala.util.Random

object DataSampler {
  def main(args: Array[String]): Unit = {
    println("=== Scala Data Sampler ===")
    val data = List(10,20,30)
    println(sample(data)) // random choice from list
  }

  private def sample(data: List[Int]): Int = data(Random.nextInt(data.size))
}
