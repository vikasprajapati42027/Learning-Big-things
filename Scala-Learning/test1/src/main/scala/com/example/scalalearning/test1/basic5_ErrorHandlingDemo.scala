package com.example.scalalearning.test1

import scala.util.{Failure, Success, Try}

object ErrorHandlingDemo {
  def main(args: Array[String]): Unit = {
    println("=== Scala Error Handling ===\n")
    demonstrateTryFold()         // safe division with Try.fold
    demonstrateRecover()         // recover from NumberFormatException
    demonstrateFoldWithEither()  // convert Try to Either and fold
    demonstrateResourceTry()     // wrap risky resource usage in Try
  }

  private def demonstrateTryFold(): Unit = {
    println("[Try.fold] safe division")
    def safeDivide(a: Int, b: Int): Try[Double] = Try(a.toDouble / b)
    val result = safeDivide(10, 2).fold(
      failure => s"failed -> ${failure.getMessage}",
      value => s"result -> $value"
    )
    println(result)
    println()
  }

  private def demonstrateRecover(): Unit = {
    println("[Try.recover] fallback value")
    val parsed = Try("not-a-number".toInt).recover {
      case _: NumberFormatException => -1
    }
    println(s"parsed -> $parsed")
    println()
  }

  private def demonstrateFoldWithEither(): Unit = {
    println("[fold] convert to Either")
    def parseInt(value: String): Either[String, Int] =
      Try(value.toInt).toEither.left.map(_ => s"invalid '$value'")

    val e = parseInt("123").fold(left => left, right => s"ok $right")
    println(e)
    println()
  }

  private def demonstrateResourceTry(): Unit = {
    println("[resource] using Try")
    class Dummy extends AutoCloseable {
      def write(text: String): Unit = println(s"writing -> $text")
      override def close(): Unit = println("closed")
    }

    val result = Try {
      val resource = new Dummy
      try {
        resource.write("safe block")
        "done"
      } finally {
        resource.close()
      }
    }
    result match {
      case Success(value) => println(s"success -> $value")
      case Failure(ex) => println(s"error -> ${ex.getMessage}")
    }
    println()
  }
}
