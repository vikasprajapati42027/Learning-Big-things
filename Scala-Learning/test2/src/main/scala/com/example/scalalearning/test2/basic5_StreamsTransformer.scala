package com.example.scalalearning.test2

object basic5_StreamsTransformer {
  def main(args: Array[String]): Unit = {
    println("=== basic5: Lazy stream transformations ===")
    val numbers = LazyList.from(1)
    val pipeline = numbers
      .map(_ * 3)
      .filter(_ % 2 == 0)
      .take(5)
      .map(n => s"transformed: $n")

    pipeline.foreach(println)
    println("(LazyList defers evaluation until terminal op)")
  }
}
