package com.example.scalalearning.test2

import scala.collection.mutable.Queue

object basic21_ReactiveBuffer {
  def main(args: Array[String]): Unit = {
    println("=== basic21: Reactive buffer ===")
    val buffer = new ReactiveBuffer[Int](3)
    buffer.subscribe(value => println(s"push -> $value"))
    (1 to 5).foreach(buffer.add)
  }

  class ReactiveBuffer[T](capacity: Int) {
    private val queue = new Queue[T]
    private var observers = Vector.empty[T => Unit]

    def add(value: T): Unit = synchronized {
      if (queue.size >= capacity) queue.dequeue()
      queue.enqueue(value)
      notifyObservers(value)
    }

    def subscribe(callback: T => Unit): Unit = observers :+= callback

    private def notifyObservers(value: T): Unit = observers.foreach(_.apply(value))
  }
}
