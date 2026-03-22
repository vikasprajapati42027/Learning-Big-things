package com.example.scalalearning.test1

object StreamStats {
  def main(args: Array[String]): Unit = {
    println("=== Scala Stream Stats ===")
    val numbers = LazyList.from(1).map(_ * 3)
    println(stats(numbers.take(5)))
  }

  private def stats(seq: LazyList[Int]): (Int, Int, Double) = {
    val list = seq.toList // convert to list to compute min/max/avg
    (list.min, list.max, list.sum.toDouble / list.size)
  }
}
