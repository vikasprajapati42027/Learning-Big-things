package com.example.scalalearning.test2

object basic77_TimeProfiler {
  def main(args: Array[String]): Unit = {
    println("=== basic77: Time profiler ===")
    println(profile(() => Thread.sleep(10)))
  }

  def profile(block: () => Unit): Long = {
    val start = System.nanoTime()
    block()
    val end = System.nanoTime()
    end - start
  }
}
