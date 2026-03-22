package com.example.scalalearning.test2

import scala.concurrent.{Await, ExecutionContext, Future, Promise}
import scala.concurrent.duration.DurationInt

object basic61_AsyncLatch {
  implicit val ec: ExecutionContext = ExecutionContext.global

  def main(args: Array[String]): Unit = {
    println("=== basic61: Async latch ===")
    val latch = Promise[Unit]()
    FutureTask(latch)
    Await.result(latch.future, 1.second)
    println("completed")
  }

  private def FutureTask(latch: Promise[Unit]): Unit = {
    ec.execute(() => {
      Thread.sleep(20)
      latch.success(())
    })
  }
}
