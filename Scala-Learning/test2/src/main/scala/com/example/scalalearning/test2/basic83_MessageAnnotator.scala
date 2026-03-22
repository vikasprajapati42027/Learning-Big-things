package com.example.scalalearning.test2

object basic83_MessageAnnotator {
  def main(args: Array[String]): Unit = {
    println("=== basic83: Message annotator ===")
    println(annotate("event"))
  }

  def annotate(message: String): String = s"[annotated] $message"
}
