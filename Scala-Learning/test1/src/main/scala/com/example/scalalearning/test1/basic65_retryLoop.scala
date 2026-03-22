package com.example.scalalearning.test1

object basic65_retryLoop {
  def main(args: Array[String]): Unit = {
    println("=== Scala basic65_retryLoop ===")
    println(attempt(3))
  }

  private def attempt(tries: Int): String = {
    if (tries <= 0) "failed"
    else if (tries == 1) "success"
    else { println(s"retry $tries"); attempt(tries - 1) }
  }
}
