package com.example.scalalearning.test2

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration.DurationInt

object basic80_AsyncProbe {
  implicit val ec: ExecutionContext = ExecutionContext.global

  def main(args: Array[String]): Unit = {
    println("=== basic80: Async probe ===")
    Await.result(Future { println("probe") }, 1.second)
  }
}
