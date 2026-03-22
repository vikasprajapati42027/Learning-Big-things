package com.example.scalalearning.test1

object basic63_optionFallback {
  def main(args: Array[String]): Unit = {
    println("=== Scala basic63_optionFallback ===")
    println(fallback(None))
  }

  private def fallback(opt: Option[String]): String = opt.getOrElse("default")
}
