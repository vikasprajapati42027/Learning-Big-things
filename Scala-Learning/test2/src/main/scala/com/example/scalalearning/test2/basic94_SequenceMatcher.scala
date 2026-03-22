package com.example.scalalearning.test2

object basic94_SequenceMatcher {
  def main(args: Array[String]): Unit = {
    println("=== basic94: Sequence matcher ===")
    println(matchSeq(List(1,2,3), List(1,2,3)))
  }

  def matchSeq(a: List[Int], b: List[Int]): Boolean = a == b
}
