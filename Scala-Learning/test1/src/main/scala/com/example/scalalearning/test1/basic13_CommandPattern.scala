package com.example.scalalearning.test1

object CommandPatternDemo {
  def main(args: Array[String]): Unit = {
    println("=== Scala Command Pattern ===\n")
    val counter = new Counter(0)
    val invoker = new CommandInvoker(Vector(Add(5, counter), Multiply(2, counter), Subtract(3, counter)))
    invoker.executeAll()
    println(s"final counter -> ${counter.value}")
    invoker.undoAll()
    println(s"after undo -> ${counter.value}\n")
  }

  trait Command {
    def execute(): Unit
    def undo(): Unit
  }

  class Counter(var value: Int)

  case class Add(amount: Int, target: Counter) extends Command {
    override def execute(): Unit = target.value += amount
    override def undo(): Unit = target.value -= amount
  }

  case class Multiply(factor: Int, target: Counter) extends Command {
    private var previous = target.value
    override def execute(): Unit = {
      previous = target.value
      target.value *= factor
    }
    override def undo(): Unit = target.value = previous
  }

  case class Subtract(amount: Int, target: Counter) extends Command {
    override def execute(): Unit = target.value -= amount
    override def undo(): Unit = target.value += amount
  }

  class CommandInvoker(commands: Vector[Command]) {
    def executeAll(): Unit = commands.foreach(_.execute())
    def undoAll(): Unit = commands.reverse.foreach(_.undo())
  }
}
