package com.example.scalalearning.test2

object basic31_ConcurrentCounter {
  def main(args: Array[String]): Unit = {
    println("=== basic31: Concurrent counter ===")
    val counter = new ConcurrentCounter
    val threads = (1 to 3).map(_ => new Thread(() => counter.increment()))
    threads.foreach(_.start()); threads.foreach(_.join())
    println(s"count -> ${counter.value}")
  }

  class ConcurrentCounter {
    @volatile private var count = 0
    def increment(): Unit = synchronized { count += 1 }
    def value: Int = count
  }
}
