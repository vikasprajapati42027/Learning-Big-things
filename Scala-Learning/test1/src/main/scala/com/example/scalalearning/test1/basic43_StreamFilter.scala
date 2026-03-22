package com.example.scalalearning.test1

object StreamFilter {
  def main(args: Array[String]): Unit = {
    println("=== Stream Filter ===")
    val values = LazyList.from(1)
    println(values.filter(_ % 2 == 0).take(3).toList)
  }
}
