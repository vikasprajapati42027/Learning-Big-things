package com.example.scalalearning.test2

object basic35_SequenceNavigator {
  def main(args: Array[String]): Unit = {
    println("=== basic35: Sequence navigator ===")
    val points = Seq(1, 2, 3, 4)
    println(stepThrough(points))
  }

  def stepThrough(seq: Seq[Int]): Seq[Int] =
    seq.sliding(2).map { case Seq(a, b) => b - a }.toSeq
}
