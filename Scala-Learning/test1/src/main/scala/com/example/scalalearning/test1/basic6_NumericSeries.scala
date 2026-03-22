package com.example.scalalearning.test1

object NumericSeries {
  def main(args: Array[String]): Unit = {
    println("=== Scala Numeric Series ===\n")
    demonstratePrimes()
    demonstrateSeries()
    demonstrateWindowed()
  }

  private def demonstratePrimes(): Unit = {
    println("[prime sieve] simple filtering")
    def isPrime(n: Int): Boolean = n > 1 && (2 to math.sqrt(n).toInt).forall(n % _ != 0)
    val primes = (2 to 30).filter(isPrime)
    println(s"primes -> $primes")
    println()
  }

  private def demonstrateSeries(): Unit = {
    println("[series] arithmetic + geometric")
    val arithmetic = LazyList.iterate(1)(_ + 3).take(5).toList
    val geometric = LazyList.iterate(1)(_ * 2).take(5).toList
    println(s"arithmetic -> $arithmetic")
    println(s"geometric -> $geometric")
    println()
  }

  private def demonstrateWindowed(): Unit = {
    println("[sliding windows] rolling averages")
    val numbers = (1 to 10).toList
    val windows = numbers.sliding(3).map(win => win.sum.toDouble / win.size).toList
    println(s"window averages -> $windows")
    println()
  }
}
