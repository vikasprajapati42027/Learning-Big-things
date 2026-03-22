package com.example.scalalearning.test2

object basic70_SafeQueue {
  def main(args: Array[String]): Unit = {
    println("=== basic70: Safe queue ===")
    val queue = new SafeQueue[Int]
    queue.offer(5)
    println(queue.poll())
  }

  class SafeQueue[T] {
    private var buffer = Vector.empty[T]
    def offer(value: T): Unit = buffer :+= value
    def poll(): Option[T] = buffer.headOption
  }
}
