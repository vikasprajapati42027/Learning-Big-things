package com.example.scalalearning.test2

object basic20_CommandRunner {
  def main(args: Array[String]): Unit = {
    println("=== basic20: Command runner ===")
    val runner = new Runner
    runner.execute("clean")
    runner.execute("build")
  }

  class Runner {
    def execute(command: String): Unit = println(s"running -> $command")
  }
}
