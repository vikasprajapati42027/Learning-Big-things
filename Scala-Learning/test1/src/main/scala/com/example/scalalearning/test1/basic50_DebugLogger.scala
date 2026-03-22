package com.example.scalalearning.test1

object DebugLogger {
  def main(args: Array[String]): Unit = {
    println("=== Debug Logger ===")
    log("startup")
  }

  private def log(message: String): Unit = println(s"[DEBUG] $message")
}
