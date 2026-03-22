package com.example.scalalearning.test2

object basic90_StrategySampler {
  def main(args: Array[String]): Unit = {
    println("=== basic90: Strategy sampler ===")
    println(sample("alpha"))
  }

  def sample(strategy: String): String = s"strategy $strategy".toUpperCase
}
