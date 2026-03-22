package com.example.scalalearning.test2

object basic91_StreamMerger {
  def main(args: Array[String]): Unit = {
    println("=== basic91: Stream merger ===")
    val left = LazyList(1,2,3)
    val right = LazyList(4,5)
    println((left ++ right).take(5).toList)
  }
}
