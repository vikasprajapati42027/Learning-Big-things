package com.example.scalalearning.test2

object basic74_ScopedLogger {
  def main(args: Array[String]): Unit = {
    println("=== basic74: Scoped logger ===")
    log("init")
  }

  def log(step: String): Unit = println(s"[scope] $step")
}
