
package com.example.scalalearning.test1

object basic98_RandomThreshold {
  def main(args: Array[String]): Unit = {
    println("=== Scala basic98_RandomThreshold ===")
    val v=scala.util.Random.nextInt(5)
    println(if(v>2)"high"else"low") // random threshold check
  }
}
