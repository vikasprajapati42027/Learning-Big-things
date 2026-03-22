package com.example.scalalearning.test1

object FunctionCombinators {
  def main(args: Array[String]): Unit = {
    println("=== Scala Function Combinators ===\n")
    demonstrateComposeAndThen()          // show compose vs andThen
    demonstrateMemoization()             // cache results with mutable Map
    demonstratePartialFunctionComposition() // extend behavior via partial functions
  }

  private def demonstrateComposeAndThen(): Unit = {
    println("[compose/andThen] chain operations")
    val multiplyBy2: Int => Int = _ * 2
    val add3: Int => Int = _ + 3
    val compose = multiplyBy2 compose add3
    val andThen = multiplyBy2 andThen add3
    println(s"compose -> ${compose(5)}")
    println(s"andThen -> ${andThen(5)}")
    println()
  }

  private def demonstrateMemoization(): Unit = {
    println("[memoize] cached fibonacci")
    def memoize[A, B](f: A => B): A => B = {
      val cache = scala.collection.mutable.Map.empty[A, B]
      a => cache.getOrElseUpdate(a, f(a))
    }
    def slowSquare(n: Int): Int = {
      Thread.sleep(50)
      n * n
    }
    val cachedSquare = memoize(slowSquare)
    println(s"first -> ${cachedSquare(5)}")
    println(s"second (cached) -> ${cachedSquare(5)}")
    println()
  }

  private def demonstratePartialFunctionComposition(): Unit = {
    println("[partial function] chain responses")
    val base: PartialFunction[Int, String] = {
      case n if n > 0 => s"positive $n"
    }
    val extended = base orElse {
      case n if n < 0 => s"negative $n"
      case _ => "zero"
    }
    println(extended(5))
    println(extended(-2))
    println(extended(0))
    println()
  }
}
