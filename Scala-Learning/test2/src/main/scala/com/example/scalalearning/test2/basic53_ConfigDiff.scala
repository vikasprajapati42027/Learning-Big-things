package com.example.scalalearning.test2

object basic53_ConfigDiff {
  def main(args: Array[String]): Unit = {
    println("=== basic53: Config diff ===")
    println(diff(Map("a"->1), Map("a"->2, "b"->3)))
  }

  def diff(oldConfig: Map[String, Int], newConfig: Map[String, Int]): Map[String, (Option[Int], Option[Int])] =
    (oldConfig.keySet ++ newConfig.keySet).map { key =>
      key -> (oldConfig.get(key), newConfig.get(key))
    }.toMap
}
