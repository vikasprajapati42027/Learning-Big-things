package com.example.scalalearning.test2

object basic26_JsonPatch {
  def main(args: Array[String]): Unit = {
    println("=== basic26: JSON patch ===")
    val base = Map("version" -> 1, "name" -> "demo")
    val patch = Map("version" -> 2, "extra" -> "new")
    println(applyPatch(base, patch))
  }

  def applyPatch(original: Map[String, Any], patch: Map[String, Any]): Map[String, Any] =
    original ++ patch
}
