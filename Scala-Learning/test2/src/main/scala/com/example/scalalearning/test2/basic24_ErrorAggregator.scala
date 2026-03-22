package com.example.scalalearning.test2

object basic24_ErrorAggregator {
  def main(args: Array[String]): Unit = {
    println("=== basic24: Error aggregator ===")
    val result = List(validateName(""), validateAge(-3)).collect { case Left(err) => err }
    if (result.isEmpty) println("all good") else println(result.mkString("; "))
  }

  def validateName(value: String): Either[String, String] =
    if (value.nonEmpty) Right(value) else Left("name empty")

  def validateAge(value: Int): Either[String, Int] =
    if (value >= 0) Right(value) else Left("age negative")
}
