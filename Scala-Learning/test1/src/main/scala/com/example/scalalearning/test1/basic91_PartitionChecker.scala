
package com.example.scalalearning.test1

object basic91_PartitionChecker {
  def main(args: Array[String]): Unit = {
    println("=== Scala basic91_PartitionChecker ===")
    val data=(1 to 10).partition(_%2==0)
    println(data) // partition into evens and odds
  }
}
