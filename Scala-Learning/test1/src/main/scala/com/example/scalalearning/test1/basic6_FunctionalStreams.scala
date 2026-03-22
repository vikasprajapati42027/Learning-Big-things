package com.example.scalalearning.test1

object FunctionalStreams {
  def main(args: Array[String]): Unit = {
    println("=== Scala Functional Streams ===\n")
    demonstrateLazyListPipeline()
    demonstrateStreamState()
    demonstrateEventStream()
  }

  private def demonstrateLazyListPipeline(): Unit = {
    println("[lazy list pipeline] squares")
    val lazySquares = LazyList.from(1).map(n => n * n).take(6)
    println(squaresToString(lazySquares))
    println()
  }

  private def squaresToString(lazySquares: LazyList[Int]): String =
    lazySquares.map(n => s"$n").mkString("->")

  private def demonstrateStreamState(): Unit = {
    println("[stateful stream] windowed sum")
    val stream = LazyList.from(1)
    val windows = stream.sliding(3).map(_.sum).take(5)
    println(windows.toList)
    println()
  }

  private def demonstrateEventStream(): Unit = {
    println("[event stream] val/var mix")
    case class Event(name: String, priority: Int)
    val queue = List(Event("start", 1), Event("load", 2), Event("finish", 3))
    val ordered = queue.sortBy(- _.priority)
    ordered.foreach(e => println(s"event -> ${e.name} priority ${e.priority}"))
    println()
  }
}
