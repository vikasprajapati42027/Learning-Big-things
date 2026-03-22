package com.example.scalalearning.test1

object ClassesAndTraits {
  def main(args: Array[String]): Unit = {
    println("=== Scala Classes & Traits ===\n")
    demonstrateCaseClass()
    demonstrateTraits()
    demonstrateCompanionObject()
    demonstrateFactory()
  }

  private def demonstrateCaseClass(): Unit = {
    println("[case class] immutable data + copy")
    case class Person(name: String, age: Int)
    val alice = Person("Alice", 30)
    val olderAlice = alice.copy(age = alice.age + 1)
    println(alice)
    println(olderAlice)
    println()
  }

  private def demonstrateTraits(): Unit = {
    println("[traits] reusable behavior")
    trait Greeter {
      def greet(name: String): String = s"Welcome, $name"
    }
    class GreeterImpl extends Greeter
    println(new GreeterImpl().greet("Scala Learner"))
    println()
  }

  private def demonstrateCompanionObject(): Unit = {
    println("[companion object] factory-like helper")
    class Rectangle(val width: Double, val height: Double) {
      def area: Double = width * height
    }
    object Rectangle {
      def square(side: Double): Rectangle = new Rectangle(side, side)
    }
    println(Rectangle.square(2.5).area)
    println()
  }

  private def demonstrateFactory(): Unit = {
    println("[factory] apply for custom creation")
    class Counter(private var current: Int) {
      def increment(): Unit = current += 1
      def value: Int = current
    }
    object Counter {
      def apply(start: Int): Counter = new Counter(start)
    }
    val counter = Counter(5)
    counter.increment()
    println(s"counter -> ${counter.value}")
    println()
  }
}
