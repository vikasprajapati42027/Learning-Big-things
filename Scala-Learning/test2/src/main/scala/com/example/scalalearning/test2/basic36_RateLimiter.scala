package com.example.scalalearning.test2

import java.util.concurrent.atomic.AtomicLong
import scala.concurrent.duration._

object basic36_RateLimiter {
  def main(args: Array[String]): Unit = {
    println("=== basic36: Rate limiter ===")
    val limiter = new RateLimiter(2, 1.second)
    (1 to 5).foreach(n => println(s"allowed -> ${limiter.acquire()}"))
  }

  class RateLimiter(max: Int, per: FiniteDuration) {
    private val count = new AtomicLong(0)
    private var windowStart = System.nanoTime()

    def acquire(): Boolean = synchronized {
      val now = System.nanoTime()
      if (now - windowStart > per.toNanos) {
        windowStart = now
        count.set(0)
      }
      if (count.get() < max) {
        count.incrementAndGet()
        true
      } else false
    }
  }
}
