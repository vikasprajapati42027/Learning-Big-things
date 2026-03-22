package com.example.scalalearning.test1

object HttpStatus {
  def main(args: Array[String]): Unit = {
    println("=== HTTP Status ===")
    val code = 404
    println(describe(code))
  }

  private def describe(code: Int): String = code match {
    case 200 => "OK"
    case 404 => "Not Found"
    case 500 => "Server Error"
    case other => s"Unknown $other"
  }
}
