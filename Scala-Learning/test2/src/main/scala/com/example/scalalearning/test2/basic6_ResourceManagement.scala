package com.example.scalalearning.test2

import scala.util.Using

object basic6_ResourceManagement {
  def main(args: Array[String]): Unit = {
    println("=== basic6: Safe resource handling ===")
    val data = "alpha,beta,gamma"
    Using.resource(new java.io.StringReader(data)) { reader =>
      val buffer = new Array[Char](data.length)
      reader.read(buffer)
      println(s"content -> ${new String(buffer)}")
    }
    println("(Using ensures reader closes even when exceptions occur)")
  }
}
