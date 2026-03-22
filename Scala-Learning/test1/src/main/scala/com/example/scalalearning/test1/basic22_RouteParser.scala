package com.example.scalalearning.test1

object RouteParser {
  def main(args: Array[String]): Unit = {
    println("=== Scala Route Parser ===\n")
    println(parseRoute("/users/42"))      // parse user route
    println(parseRoute("/products/123"))  // parse product route
  }

  private val routePattern = "/([a-z]+)/([0-9]+)".r

  private def parseRoute(path: String): String = path match {
    case routePattern(entity, id) => s"entity=$entity id=$id"
    case _ => "no match"
  }
}
