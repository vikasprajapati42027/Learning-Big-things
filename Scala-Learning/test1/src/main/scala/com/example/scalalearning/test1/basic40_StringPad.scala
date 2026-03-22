package com.example.scalalearning.test1

object StringPad {
  def main(args: Array[String]): Unit = {
    println("=== String Pad ===")
    println(pad("scala", 8))
  }

  private def pad(value: String, length: Int): String = value.padTo(length, '*')
}
