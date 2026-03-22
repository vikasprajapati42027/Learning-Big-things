package com.example.scalalearning.test2

object basic55_FallbackRouter {
  def main(args: Array[String]): Unit = {
    println("=== basic55: Fallback router ===")
    println(route("missing"))
  }

  def route(path: String): String = path match {
    case "home" => "home service"
    case _ => "fallback"
  }
}
