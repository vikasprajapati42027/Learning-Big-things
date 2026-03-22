package com.example.scalalearning.test1

object basic70_msgBuilders {
  def main(args: Array[String]): Unit = {
    println("=== Scala basic70_msgBuilders ===")
    println(buildMsg("hello"))
  }

  private def buildMsg(text: String): String = s"[MSG] $text"
}
