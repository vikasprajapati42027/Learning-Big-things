package com.example.scalalearning.test1

object CommandArgs {
  def main(args: Array[String]): Unit = {
    println("=== Scala Command Args ===")
    println(parse(Array("--name","scala","--level","pro")))
  }

  private def parse(args: Array[String]): Map[String, String] =
    args.sliding(2,2).collect { case Array(key,value) if key.startsWith("--") => key.drop(2)->value }.toMap // simple CLI parser
}
