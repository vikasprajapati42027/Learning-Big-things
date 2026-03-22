package com.example.scalalearning.test2

object basic57_TraceLogger {
  def main(args: Array[String]): Unit = {
    println("=== basic57: Trace logger ===")
    trace("start")
  }

  def trace(step: String): Unit = println(s"trace -> $step")
}
