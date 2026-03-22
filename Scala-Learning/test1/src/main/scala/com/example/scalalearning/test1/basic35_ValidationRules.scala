package com.example.scalalearning.test1

object ValidationRules {
  def main(args: Array[String]): Unit = {
    println("=== Validation Rules ===")
    val result = if (isValid("abc")) "valid" else "reject"
    println(result)
  }

  private def isValid(value: String): Boolean = value.length >= 3
}
