package com.example.scalalearning.test2

import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, Future}

object basic25_TemporalScheduler {
  implicit val ec: ExecutionContext = ExecutionContext.global

  def main(args: Array[String]): Unit = {
    println("=== basic25: Temporal scheduler ===")
    val future = Future.sequence((1 to 3).map(delay))
    println(s"results -> ${Await.result(future, 1.second)}")
  }

  private def delay(value: Int): Future[String] = Future {
    Thread.sleep(50 * value)
    s"tick $value"
  }
}
