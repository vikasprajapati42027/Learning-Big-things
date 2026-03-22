package com.example.scalalearning.test2

object basic51_HealthCheck {
  def main(args: Array[String]): Unit = {
    println("=== basic51: Health check ===")
    println(check())
  }

  def check(): String = "OK"
}
