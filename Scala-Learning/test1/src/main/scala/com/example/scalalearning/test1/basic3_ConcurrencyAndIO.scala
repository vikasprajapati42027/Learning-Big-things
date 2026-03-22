package com.example.scalalearning.test1

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
import scala.concurrent.Await
import scala.concurrent.duration.Duration

object ConcurrencyAndIO {
  def main(args: Array[String]): Unit = {
    println("=== Scala Concurrency & IO Basics ===\n")
    demonstrateFutureFlow()
    demonstrateFutureSequence()
    demonstrateBlockingIO()
    demonstrateThreadLocal()
  }

  private def demonstrateFutureFlow(): Unit = {
    println("[Future] async computation")
    val future = Future {
      Thread.sleep(200)
      7 * 7
    }
    future.onComplete {
      case Success(value) => println(s"computed -> $value")
      case Failure(ex)    => println(s"failed -> ${ex.getMessage}")
    }
    Await.ready(future, Duration.Inf)
    println()
  }

  private def demonstrateFutureSequence(): Unit = {
    println("[Future.sequence] collect list")
    val futures = (1 to 3).map(i => Future { i * 10 })
    val aggregated = Future.sequence(futures)
    println(s"sequence -> ${Await.result(aggregated, Duration.Inf)}")
    println()
  }

  private def demonstrateBlockingIO(): Unit = {
    println("[blocking IO] simulated wait")
    val ioTask = Future {
      Thread.sleep(100)
      "data from io"
    }
    println(s"blocking result -> ${Await.result(ioTask, Duration.Inf)}")
    println()
  }

  private def demonstrateThreadLocal(): Unit = {
    println("[ThreadLocal] simple propagation")
    val threadLocal = new ThreadLocal[String]()
    threadLocal.set("main-context")
    val runner = new Thread(() => println(s"thread sees -> ${threadLocal.get()}"))
    runner.start()
    runner.join()
    println()
  }
}
