package com.example.scalalearning.test2

object basic34_ConfigMerger {
  def main(args: Array[String]): Unit = {
    println("=== basic34: Config merger ===")
    val base = Map("host" -> "a", "port" -> "8080")
    val overrideConfig = Map("port" -> "9090", "tls" -> "true")
    println(merge(base, overrideConfig))
  }

  def merge(base: Map[String, String], overrideWith: Map[String, String]): Map[String, String] =
    base ++ overrideWith
}
