package com.example.scalalearning.test1

object LazyTransforms {
  def main(args: Array[String]): Unit = {
    println("=== Scala Lazy Transforms ===\n")
    val lazySeq = LazyList.from(1).map(_ * 3).filter(_ % 2 == 0)
    println(s"first five -> ${lazySeq.take(5).toList}") // evaluate lazily
  }
}
