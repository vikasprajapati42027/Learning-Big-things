
package com.example.scalalearning.test1

object basic94_WindowedSum {
  def main(args: Array[String]): Unit = {
    println("=== Scala basic94_WindowedSum ===")
    println((1 to 5).sliding(3).map(_.sum).toList) // sliding sums
  }
}
