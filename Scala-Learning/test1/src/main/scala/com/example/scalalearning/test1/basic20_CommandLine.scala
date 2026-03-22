package com.example.scalalearning.test1

object CommandLineDemo {
  def main(args: Array[String]): Unit = {
    println("=== Scala Command Line Demo ===\n")
    println(parseArgs(Array("--mode", "dev", "--debug")))
  }

  private def parseArgs(args: Array[String]): Map[String, String] = {
    args.sliding(2, 2).collect {
      case Array(key, value) if key.startsWith("--") => key.drop(2) -> value
    }.toMap // build map of CLI options
  }
}
