package com.example.scalalearning.test1

object KeyValueMerger {
  def main(args: Array[String]): Unit = {
    println("=== KeyValue Merger ===")
    println(merge(Map("a"->1), Map("b"->2)))
  }

  private def merge(first: Map[String, Int], second: Map[String, Int]): Map[String, Int] =
    first ++ second.view.mapValues(_ + 100)
}
