package com.example.scalalearning.test2

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration.DurationInt

object basic82_FutureAggregator {
  implicit val ec: ExecutionContext = ExecutionContext.global

  def main(args: Array[String]): Unit = {
    println("=== basic82: Future aggregator ===")
    val futures = Future.sequence(List(Future(10), Future(20)))(implicitly, ec)
    println(Await.result(futures.map(_.sum), 1.second))
  }
}
