package com.example.scalalearning.test2

import scala.util.Random

object basic92_RequestSampler {
  def main(args: Array[String]): Unit = {
    println("=== basic92: Request sampler ===")
    println(sample())
  }

  def sample(): Int = Random.nextInt(100)
}
