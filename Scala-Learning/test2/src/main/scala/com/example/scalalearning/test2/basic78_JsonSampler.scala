package com.example.scalalearning.test2

object basic78_JsonSampler {
  def main(args: Array[String]): Unit = {
    println("=== basic78: JSON sampler ===")
    println(sample(Map("a" -> 1, "b" -> 2)))
  }

  def sample(payload: Map[String, Int]): Map[String, Int] = payload.filter(_._2 % 2 == 0)
}
