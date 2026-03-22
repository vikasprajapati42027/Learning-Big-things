package com.example.scalalearning.test2

import scala.collection.mutable.Queue
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, ExecutionContext, Future}

object basic19_Backpressure {
  implicit val ec: ExecutionContext = ExecutionContext.global

  def main(args: Array[String]): Unit = {
    println("=== basic19: Backpressure signal ===")
    val queue = new Queue[Int]
    val producer = Future {
      (1 to 5).foreach { n =>
        queue.synchronized {
          queue.enqueue(n)
          println(s"produced -> $n (size -> ${queue.size})")
          while (queue.size >= 2) queue.wait()
        }
      }
    }

    val consumer = Future {
      while (queue.isEmpty) Thread.sleep(50)
      while (queue.nonEmpty) {
        queue.synchronized {
          val value = queue.dequeue()
          println(s"consumed -> $value")
          queue.notify()
        }
        Thread.sleep(70)
      }
    }

    Await.result(producer, 5.seconds)
    Await.result(consumer, 5.seconds)
  }
}
