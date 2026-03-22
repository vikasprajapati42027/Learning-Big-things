package com.example.scalalearning.test2

object basic43_TokenBucket {
  def main(args: Array[String]): Unit = {
    println("=== basic43: Token bucket ===")
    val bucket = new TokenBucket(3)
    (1 to 5).foreach(n => println(s"allow $n -> ${bucket.tryConsume()}"))
  }

  class TokenBucket(capacity: Int) {
    private var tokens = capacity
    def tryConsume(): Boolean = synchronized {
      if (tokens > 0) {
        tokens -= 1
        true
      } else false
    }
  }
}
