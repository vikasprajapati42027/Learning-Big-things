package com.example.scalalearning.test1

object Scheduler {
  def main(args: Array[String]): Unit = {
    println("=== Scala Scheduler ===\n")
    val tasks = Seq("backup", "cleanup", "report")
    schedule(tasks)
  }

  private def schedule(tasks: Seq[String]): Unit = {
    tasks.zipWithIndex.foreach { case (task, idx) => println(s"run #$idx -> $task") } // print task order
  }
}
