package com.example.scalalearning.test1

import scala.collection.parallel.CollectionConverters._

object ParallelCollectionDemo {
  def main(args: Array[String]): Unit = {
    println("=== Scala Parallel Collection Demo ===\n")
    demonstrateParallelMap()
    demonstrateParallelAggregate()
    demonstrateParallelSideEffect()
  }

  private def demonstrateParallelMap(): Unit = {
    println("[parallel map] transform quickly")
    val values = (1 to 20).toList
    val doubled = values.par.map(_ * 2)
    println(s"first few -> ${doubled.take(5).toList}")
    println()
  }

  private def demonstrateParallelAggregate(): Unit = {
    println("[parallel aggregate] sum of squares")
    val sumSquares = (1 to 100).par.aggregate(0)((acc, value) => acc + value * value, _ + _)
    println(s"sum squares -> $sumSquares")
    println()
  }

  private def demonstrateParallelSideEffect(): Unit = {
    println("[parallel side-effect] thread ids")
    val buffer = scala.collection.concurrent.TrieMap.empty[Int, Long]
    (1 to 10).par.foreach(v => buffer.put(v, Thread.currentThread().getId))
    println(s"mapped threads -> ${buffer.map { case (k, t) => s"$k->$t" }.mkString(",")} ")
    println()
  }
}
