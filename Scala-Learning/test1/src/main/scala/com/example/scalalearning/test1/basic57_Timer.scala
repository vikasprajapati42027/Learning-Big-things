package com.example.scalalearning.test1

object Timer {
  def main(args: Array[String]): Unit = {
    println("=== Scala Timer ===")
    timeBlock { Thread.sleep(10); println("inside") } // measure block duration
  }

  private def timeBlock(block: => Unit): Unit = {
    val start = System.currentTimeMillis()
    block
    println(s"took ${System.currentTimeMillis()-start}ms")
  }
}
