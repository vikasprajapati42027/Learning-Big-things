package com.example.scalalearning.test2

object basic1_PatternShowcase {
  sealed trait Input
  case class Text(value: String) extends Input
  case class Number(value: Int) extends Input
  case object Empty extends Input

  def main(args: Array[String]): Unit = {
    println("=== Scala Pattern Showcase ===")
    List(Text("hello"), Number(3), Empty).foreach(consume)
  }

  private def consume(input: Input): Unit = input match {
    case Text(txt) if txt.nonEmpty => println(s"text -> $txt")
    case Number(n) if n % 2 == 0 => println(s"even number -> $n")
    case Number(n) => println(s"odd number -> $n")
    case Empty => println("empty input")
  }
}
