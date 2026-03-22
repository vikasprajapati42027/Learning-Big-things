package com.example.scalalearning.test1

object MetricsAggregator {
  def main(args: Array[String]): Unit = {
    println("=== Scala Metrics Aggregator ===\n")
    val samples = Map("requests" -> List(1, 2, 3), "errors" -> List(0, 1))
    println(aggregate(samples))
  }

  private def aggregate(data: Map[String, List[Int]]): Map[String, Int] =
    data.view.mapValues(_.sum).toMap // sum each metric's samples
}
