package com.example.scalalearning.test2

object basic60_ErrorResponder {
  def main(args: Array[String]): Unit = {
    println("=== basic60: Error responder ===")
    println(respond(Some("timeout")))
  }

  def respond(error: Option[String]): String = error.map(e => s"error -> $e").getOrElse("ok")
}
