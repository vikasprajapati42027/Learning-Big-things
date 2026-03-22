package com.example.scalalearning.test2

object basic32_DataNormalizer {
  def main(args: Array[String]): Unit = {
    println("=== basic32: Data normalizer ===")
    val raw = List("  Scala", "learning  ", "  Labs")
    println(normalize(raw))
  }

  def normalize(values: List[String]): List[String] =
    values.map(_.trim.toLowerCase).distinct
}
