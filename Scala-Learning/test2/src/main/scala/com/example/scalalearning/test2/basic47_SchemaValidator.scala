package com.example.scalalearning.test2

object basic47_SchemaValidator {
  def main(args: Array[String]): Unit = {
    println("=== basic47: Schema validator ===")
    println(validate(Map("name" -> "v")))
  }

  def validate(data: Map[String, String]): Boolean =
    data.contains("name") && data.get("value").exists(_.nonEmpty)
}
