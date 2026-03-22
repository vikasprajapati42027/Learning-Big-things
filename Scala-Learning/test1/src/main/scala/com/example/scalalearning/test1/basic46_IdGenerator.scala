package com.example.scalalearning.test1

object IdGenerator {
  def main(args: Array[String]): Unit = {
    println("=== ID Generator ===")
    println(generate())
  }

  private var counter = 0
  private def generate(): String = {
    counter += 1
    s"id-$counter"
  }
}
