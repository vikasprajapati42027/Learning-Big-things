package com.example.scalalearning.test1

object TaskQueue {
  def main(args: Array[String]): Unit = {
    println("=== Scala Task Queue ===")
    val tasks = scala.collection.mutable.Queue("alpha","beta") // initial tasks
    enqueue(tasks,"gamma") // add another task
    process(tasks) // drain queue
  }

  private def enqueue(queue: scala.collection.mutable.Queue[String], item: String): Unit = queue.enqueue(item)
  private def process(queue: scala.collection.mutable.Queue[String]): Unit = while(queue.nonEmpty) println(s"processing -> ${queue.dequeue()}")
}
