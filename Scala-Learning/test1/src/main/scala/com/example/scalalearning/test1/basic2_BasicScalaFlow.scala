package com.example.scalalearning.test1

object BasicScalaFlow {
  def main(args: Array[String]): Unit = {
    println("=== Scala Basic Flow Patterns ===\n")
    demonstrateLazyEval()
    demonstrateHigherOrder()
    demonstrateTailRecursion()
    demonstratePartialFunction()
    demonstrateCollectionsTransform()
    demonstrateTryCatch()
    demonstrateEither()
    demonstrateImplicitConversion()
  }

  private def demonstrateLazyEval(): Unit = {
    println("[lazy val] triggered only once")
    lazy val timestamp = {
      println("computing timestamp")
      System.currentTimeMillis()
    }
    println(s"first call -> $timestamp")
    println(s"second call -> $timestamp")
    println()
  }

  private def demonstrateHigherOrder(): Unit = {
    println("[higher-order] functions as values")
    def repeat(n: Int)(op: => Unit): Unit = {
      if (n > 0) {
        op
        repeat(n - 1)(op)
      }
    }

    repeat(3)(println("higher-order ping"))
    val adder: Int => Int = _ + 5
    println(s"adder(7) -> ${adder(7)}")
    println()
  }

  private def demonstrateTailRecursion(): Unit = {
    println("[tail recursion] factorial example")
    def factorial(n: Int): BigInt = {
      @annotation.tailrec
      def loop(curr: Int, acc: BigInt): BigInt =
        if (curr <= 1) acc else loop(curr - 1, acc * curr)
      loop(n, 1)
    }
    println(s"factorial 5 -> ${factorial(5)}")
    println()
  }

  private def demonstratePartialFunction(): Unit = {
    println("[partial function] simple extractor")
    val describe: PartialFunction[Any, String] = {
      case i: Int if i > 0 => s"positive -> $i"
      case s: String       => s"string -> $s"
    }
    println(describe(3))
    println(describe("scala"))
    println()
  }

  private def demonstrateCollectionsTransform(): Unit = {
    println("[collection transforms] grouped, zipped, folds")
    val words = Seq("alpha", "beta", "gamma", "delta")
    println(s"grouped -> ${words.grouped(2).toList}")

    val zipped = words.zipWithIndex
    zipped.foreach { case (word, idx) => println(s"zipped -> $word@$idx") }

    val numbers = 1 to 5
    val folded = numbers.foldLeft(0)(_ + _)
    println(s"folded sum -> $folded")
    println()
  }

  private def demonstrateTryCatch(): Unit = {
    println("[try/catch] safe parsing")
    def parseInt(value: String): Option[Int] =
      try {
        Some(value.toInt)
      } catch {
        case _: NumberFormatException => None
      }

    println(parseInt("123"))
    println(parseInt("NaN"))
    println()
  }

  private def demonstrateEither(): Unit = {
    println("[either] accumulate valid results")
    def divide(dividend: Int, divisor: Int): Either[String, Double] =
      if (divisor == 0) Left("divide by zero") else Right(dividend.toDouble / divisor)

    val results = for {
      a <- divide(10, 2).toOption.toList
      b <- divide(12, 3).toOption.toList
    } yield a + b

    println(s"combined -> $results")
    println(divide(10, 0))
    println()
  }

  private def demonstrateImplicitConversion(): Unit = {
    println("[implicit conversion] enriched strings")
    implicit class StringOps(value: String) {
      def shout: String = value.toUpperCase() + "!"
    }

    val message: String = "scala"
    println(s"shout -> ${message.shout}")
    println()
  }
}
