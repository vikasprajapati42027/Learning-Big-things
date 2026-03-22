package com.example.scalalearning.test2

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration.DurationInt

object basic75_ParallelMapper {
  implicit val ec: ExecutionContext = ExecutionContext.global

  def main(args: Array[String]): Unit = {
    println("=== basic75: Parallel mapper ===")
    val result = Await.result(Future.sequence((1 to 3).map(i => Future(i * 2))), 1.second)
    println(result)
  }
}
