package com.example.scalalearning.test2

object basic40_MetricsReporter {
  def main(args: Array[String]): Unit = {
    println("=== basic40: Metrics reporter ===")
    val reporter = new Reporter
    reporter.record("requests", 10)
    reporter.record("errors", 1)
    reporter.dump()
  }

  class Reporter {
    private var metrics = Map.empty[String, Int]
    def record(key: String, value: Int): Unit =
      metrics = metrics.updatedWith(key) { case Some(v) => Some(v + value); case None => Some(value) }
    def dump(): Unit = metrics.foreach { case (k, v) => println(s"$k -> $v") }
  }
}
