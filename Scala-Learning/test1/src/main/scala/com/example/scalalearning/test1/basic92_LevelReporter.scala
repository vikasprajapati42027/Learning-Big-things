
package com.example.scalalearning.test1

object basic92_LevelReporter {
  def main(args: Array[String]): Unit = {
    println("=== Scala basic92_LevelReporter ===")
    def report(level:String)=s"level=$level"
    println(report("warn")) // simple formatter
  }
}
