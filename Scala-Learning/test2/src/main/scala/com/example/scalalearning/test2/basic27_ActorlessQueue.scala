package com.example.scalalearning.test2

import scala.collection.mutable

object basic27_ActorlessQueue {
  def main(args: Array[String]): Unit = {
    println("=== basic27: Actorless queue ===")
    val queue = new Queue[Int]
    queue.offer(1)
    queue.offer(2)
    println(queue.take())
    println(queue.take())
  }

  class Queue[T] {
    private val buffer = mutable.Queue.empty[T]
    def offer(item: T): Unit = buffer.enqueue(item)
    def take(): T = buffer.dequeue()
  }
}
