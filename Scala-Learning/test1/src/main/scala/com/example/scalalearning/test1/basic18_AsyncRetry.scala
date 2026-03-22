package com.example.scalalearning.test1

object AsyncRetry {
  def main(args: Array[String]): Unit = {
    println("=== Scala Async Retry ===\n")
    println(attempt(3)) // try 3 times before failing
  }

  private def attempt(tries: Int): String = {
    if (tries <= 0) "failed"
    else {
      println(s"trying with $tries")
      if (tries == 1) "success" else attempt(tries - 1)
    }
  }
}
