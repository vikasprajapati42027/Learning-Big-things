package com.example.scalalearning.test1

object TimestampUtils {
  def main(args: Array[String]): Unit = {
    println("=== Timestamp Utils ===")
    println(current())
  }

  private def current(): Long = System.currentTimeMillis()
}
