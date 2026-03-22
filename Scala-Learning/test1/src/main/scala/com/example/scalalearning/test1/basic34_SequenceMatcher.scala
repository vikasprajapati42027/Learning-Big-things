package com.example.scalalearning.test1

object SequenceMatcher {
  def main(args: Array[String]): Unit = {
    println("=== Sequence Matcher ===")
    println(matchSeq(List(1,2,3)))
  }

  private def matchSeq(seq: List[Int]): String = seq match {
    case 1 :: 2 :: rest => s"starts with 1,2 rest=$rest"
    case _ => "no match"
  }
}
