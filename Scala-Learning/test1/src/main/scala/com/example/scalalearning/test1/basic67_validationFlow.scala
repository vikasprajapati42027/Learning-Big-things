package com.example.scalalearning.test1

object basic67_validationFlow {
  def main(args: Array[String]): Unit = {
    println("=== Scala basic67_validationFlow ===")
    println(validate(5))
  }

  private def validate(x: Int): Boolean = x > 0 && x % 2 == 1
}
