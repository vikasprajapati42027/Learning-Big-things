package com.example.scalalearning.test1

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object EffectfulFunctionDemo {
  def main(args: Array[String]): Unit = {
    println("=== Scala Effectful Functions ===\n")
    demonstrateOptionFlow()        // chain Option operations
    demonstrateEitherFlow()        // compose Either-based validation
    demonstrateFutureTransform()   // map/flatMap Future values
  }

  private def demonstrateOptionFlow(): Unit = {
    println("[Option] map -> flatMap chain")
    val maybeNumber = Option(5)
    val result = maybeNumber.map(_ * 2).flatMap(n => if (n > 5) Some(n.toString) else None)
    println(s"option flow -> $result")
    println()
  }

  private def demonstrateEitherFlow(): Unit = {
    println("[Either] fold -> for-comprehension")
    def validate(item: String): Either[String, String] =
      if (item.nonEmpty) Right(item.toUpperCase) else Left("empty")

    val either = for {
      a <- validate("scala")
      b <- validate("")
    } yield s"$a + $b"

    println(s"either chain -> ${either.swap.getOrElse("valid chain")}")
    println()
  }

  private def demonstrateFutureTransform(): Unit = {
    println("[Future] async mapping")
    val futureResult = Future(10).map(_ * 3).flatMap(v => Future(v + 4))
    futureResult.onComplete {
      case Success(value) => println(s"future result -> $value")
      case Failure(ex) => println(s"future failure -> ${ex.getMessage}")
    }
    Thread.sleep(300)
    println()
  }
}
