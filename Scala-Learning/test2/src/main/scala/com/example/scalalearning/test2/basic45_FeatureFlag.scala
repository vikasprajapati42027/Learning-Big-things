package com.example.scalalearning.test2

object basic45_FeatureFlag {
  def main(args: Array[String]): Unit = {
    println("=== basic45: Feature flag ===")
    val flags = Map("beta" -> true, "legacy" -> false)
    println(if (flags.getOrElse("beta", false)) "beta enabled" else "beta disabled")
  }
}
