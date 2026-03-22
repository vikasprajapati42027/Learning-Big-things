package com.example.scalalearning.test2

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration.DurationInt

object basic4_AsyncCombinators {
  implicit val ec: ExecutionContext = ExecutionContext.global

  def main(args: Array[String]): Unit = {
    println("=== basic4: Async combinators ===")
    val square = asyncSquare(4)
    val triple = asyncSquare(3)

    val combined = for {
      s <- square
      t <- triple
    } yield s + t

    println(s"future sum -> ${Await.result(combined, 2.seconds)}")
    println("(all futures remain non-blocking until this final Await)")
  }

  private def asyncSquare(value: Int): Future[Int] = Future {
    Thread.sleep(50)
    value * value
  }
}
