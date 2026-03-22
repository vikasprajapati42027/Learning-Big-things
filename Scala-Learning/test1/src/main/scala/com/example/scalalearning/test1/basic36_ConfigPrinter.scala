package com.example.scalalearning.test1

object ConfigPrinter {
  def main(args: Array[String]): Unit = {
    println("=== Config Printer ===")
    val cfg = Map("env" -> "prod", "debug" -> "false")
    cfg.foreach { case (k,v) => println(s"$k=$v") }
  }
}
