package com.example.scalalearning.test2

import scala.util.Try

object basic67_SafeParser {
  def main(args: Array[String]): Unit = {
    println("=== basic67: Safe parser ===")
    println(parseInt("123"))
    println(parseInt("oops"))
  }

  def parseInt(value: String): Either[String, Int] =
    Try(value.toInt).toEither.left.map(_ => s"invalid $value")
}
