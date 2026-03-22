package com.example.scalalearning.test2

import java.security.MessageDigest
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration.DurationInt

object basic62_ParallelHasher {
  implicit val ec: ExecutionContext = ExecutionContext.global

  def main(args: Array[String]): Unit = {
    println("=== basic62: Parallel hasher ===")
    val hashes = Future.sequence((1 to 3).map(i => Future { hash(s"value-$i") }))
    println(Await.result(hashes, 1.second))
  }

  def hash(value: String): String = {
    val digest = MessageDigest.getInstance("MD5")
    digest.update(value.getBytes("UTF-8"))
    digest.digest().map(b => f"$b%02x").mkString
  }
}
