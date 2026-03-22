package com.example.scalalearning.test2

object basic30_ConfigValidationFlow {
  def main(args: Array[String]): Unit = {
    println("=== basic30: Config validation flow ===")
    val raw = Map("threads" -> "4", "mode" -> "safe")
    println(validate(raw))
  }

  sealed trait ConfigState
  case object Valid extends ConfigState
  case class Invalid(errors: List[String]) extends ConfigState

  def validate(data: Map[String, String]): ConfigState = {
    val errors = List(
      data.get("threads").flatMap(s => util.Try(s.toInt).toOption).filter(_ > 0).toRight("threads invalid").swap.toOption,
      data.get("mode").filter(m => Set("safe", "fast").contains(m)).toRight("mode unsupported").swap.toOption
    ).flatten

    if (errors.isEmpty) Valid else Invalid(errors)
  }
}
