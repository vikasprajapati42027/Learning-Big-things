package com.example.scalalearning.test1

object BinaryMask {
  def main(args: Array[String]): Unit = {
    println("=== Scala Binary Mask ===\n")
    val mask = generateMask(5)
    println(s"mask -> ${mask.mkString}")
  }

  private def generateMask(size: Int): String = (1 to size).map(i => if (i % 2 == 0) '1' else '0').mkString // alternating bits
}
