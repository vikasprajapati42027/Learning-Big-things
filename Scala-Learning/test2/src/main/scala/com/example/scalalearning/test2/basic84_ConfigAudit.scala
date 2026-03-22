package com.example.scalalearning.test2

object basic84_ConfigAudit {
  def main(args: Array[String]): Unit = {
    println("=== basic84: Config audit ===")
    println(audit(Map("feature" -> "on")))
  }

  def audit(config: Map[String, String]): String = config.map { case (k, v) => s"$k=$v" }.mkString(",")
}
