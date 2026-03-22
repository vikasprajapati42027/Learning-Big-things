package com.example.scalalearning.test2

import scala.util.Try

object basic50_RetryOrchestrator {
  def main(args: Array[String]): Unit = {
    println("=== basic50: Retry orchestrator ===")
    println(retry(() => Try(throw new IllegalStateException("boom")), 2))
  }

  def retry[T](block: () => Try[T], attempts: Int): Try[T] =
    if (attempts <= 0) block()
    else block().recoverWith { case _ => retry(block, attempts - 1) }
}
