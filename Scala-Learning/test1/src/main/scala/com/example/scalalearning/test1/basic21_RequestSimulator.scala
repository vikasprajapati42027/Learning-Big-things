package com.example.scalalearning.test1

object RequestSimulator {
  // simple simulation of REST-like requests & responses
  def main(args: Array[String]): Unit = {
    println("=== Scala Request Simulator ===\n")
    simulateRequest("GET", "/status")      // simulate a GET request
    simulateRequest("POST", "/items")      // simulate a POST request
  }

  private def simulateRequest(method: String, path: String): Unit = {
    val response = method match {
      case "GET"  => s"$path -> 200 OK"
      case "POST" => s"$path -> 201 Created"
      case other   => s"$path -> 405 Method $other not allowed"
    }
    println(response)
  }
}
