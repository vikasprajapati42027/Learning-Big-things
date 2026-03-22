package com.example.scalalearning.test2

object basic14_MonadicFlow {
  def main(args: Array[String]): Unit = {
    println("=== basic14: Monadic flow ===")
    val result = for {
      a <- Option(5)
      b <- Some(a * 2)
      c <- (1 to b).toList.find(_ % 3 == 0)
    } yield c
    println(s"flow result -> $result")
    println("(for-comprehension threads optional/list logic)")
  }
}
