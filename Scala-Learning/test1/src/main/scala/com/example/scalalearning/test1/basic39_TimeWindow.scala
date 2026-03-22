package com.example.scalalearning.test1

object TimeWindow {
  def main(args: Array[String]): Unit = {
    println("=== Time Window ===")
    println(window(Seq(10,20,30), 2))
  }

  private def window(data: Seq[Int], size: Int): Seq[Seq[Int]] = data.sliding(size).toSeq
}
