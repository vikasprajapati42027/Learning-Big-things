package com.example.scalalearning.test2

object basic3_AdvancedFunctionality {
  def main(args: Array[String]): Unit = {
    println("=== basic3: Advanced Function Concepts ===\n")
    demonstrateTailRecursion()
    demonstrateTrampoline()
    demonstrateEitherOperations()
    demonstrateReaderLikeBuilder()
  }

  private def demonstrateTailRecursion(): Unit = {
    println("[tail recursion] fibonacci")
    def fib(n: Int): BigInt = {
      @annotation.tailrec
      def loop(i: Int, prev: BigInt, curr: BigInt): BigInt =
        if (i >= n) curr
        else loop(i + 1, curr, prev + curr)
      if (n <= 1) n
      else loop(1, 0, 1)
    }
    println(s"fib 10 -> ${fib(10)}")
    println()
  }

  private trait Tron[T] {
    def run(): T
  }

  private case class Done[T](result: T) extends Tron[T] {
    def run() = result
  }

  private case class Suspend[T](resume: () => Tron[T]) extends Tron[T] {
    def run() = resume().run()
  }

  private def demonstrateTrampoline(): Unit = {
    println("[trampoline] stack-safe loop")
    def trampoline[T](t: Tron[T]): T = t match {
      case Done(value) => value
      case Suspend(resume) => trampoline(resume())
    }

    def factorial(n: Int): Tron[BigInt] = {
      def loop(curr: Int, acc: BigInt): Tron[BigInt] =
        if (curr <= 1) Done(acc)
        else Suspend(() => loop(curr - 1, acc * curr))
      loop(n, 1)
    }

    println(s"trampoline factorial 5 -> ${trampoline(factorial(5))}")
    println()
  }

  private def demonstrateEitherOperations(): Unit = {
    println("[either ops] parsing numbers")
    def parseNumber(value: String): Either[String, Int] =
      util.Try(value.toInt).toEither.left.map(_ => s"invalid '$value'")

    val sum = for {
      a <- parseNumber("10")
      b <- parseNumber("20")
    } yield a + b

    println(s"sum result -> $sum")
    println(parseNumber("oops"))
    println()
  }

  private def demonstrateReaderLikeBuilder(): Unit = {
    println("[builder] reader-like transformation")
    case class Config(host: String, port: Int)
    class Connector(config: Config) {
      def connect(): String = s"connected to ${config.host}:${config.port}"
    }

    val connectorBuilder: Config => Connector = config => new Connector(config)
    def withConfig(f: Config => Connector): String = f(Config("localhost", 8080)).connect()

    println(withConfig(connectorBuilder))
    println()
  }
}
