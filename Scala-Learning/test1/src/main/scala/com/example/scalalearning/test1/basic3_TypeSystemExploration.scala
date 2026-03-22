package com.example.scalalearning.test1

object TypeSystemExploration {
  def main(args: Array[String]): Unit = {
    println("=== Scala Type System Exploration ===\n")
    demonstrateGenerics()
    demonstrateContextBound()
    demonstrateStructuralTyping()
    demonstrateTypeAlias()
    demonstrateDependentTypes()
  }

  private def demonstrateGenerics(): Unit = {
    println("[generics] generic pair and swapping")
    case class Pair[A, B](first: A, second: B) {
      def swap: Pair[B, A] = Pair(second, first)
    }
    val pair = Pair("scala", 42)
    println(pair)
    println(pair.swap)
    println()
  }

  private def demonstrateContextBound(): Unit = {
    println("[context bound] ordering")
    def sortedList[T: Ordering](items: List[T]): List[T] = items.sorted
    println(sortedList(List(3, 1, 4, 2)))
    println()
  }

  private def demonstrateStructuralTyping(): Unit = {
    println("[structural type] duck typing")
    def closeResource(resource: { def close(): Unit }): Unit = resource.close()
    val closable = new AutoCloseable {
      override def close(): Unit = println("structural closed")
    }
    closeResource(closable)
    println()
  }

  private def demonstrateTypeAlias(): Unit = {
    println("[type alias] clearer intent")
    type Metric = Double
    type Name = String

    def report(name: Name, value: Metric): String = s"$name -> $value"
    println(report("load", 0.73))
    println()
  }

  private def demonstrateDependentTypes(): Unit = {
    println("[dependent type] path-dependent holder")
    class Container { class Item(val value: String) }
    val containerA = new Container
    val containerB = new Container
    val itemA: containerA.Item = new containerA.Item("A")
    // val wrong: containerB.Item = itemA // would not compile
    println(s"item from A -> ${itemA.value}")
    println()
  }
}
