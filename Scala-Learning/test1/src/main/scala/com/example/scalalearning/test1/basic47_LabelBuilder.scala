package com.example.scalalearning.test1

object LabelBuilder {
  def main(args: Array[String]): Unit = {
    println("=== Label Builder ===")
    println(build("alpha", "beta"))
  }

  private def build(parts: String*): String = parts.mkString("-")
}
