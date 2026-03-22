package com.example.scalalearning.test2

object basic46_JsonZipper {
  def main(args: Array[String]): Unit = {
    println("=== basic46: JSON zipper ===")
    val merged = zipMaps(Map("a" -> 1), Map("b" -> 2))
    println(merged)
  }

  def zipMaps[A, B](left: Map[String, A], right: Map[String, B]): Map[String, Either[A, B]] =
    (left.keySet ++ right.keySet).map { key =>
      key -> (left.get(key).map(Left(_)).orElse(right.get(key).map(Right(_))).get)
    }.toMap
}
