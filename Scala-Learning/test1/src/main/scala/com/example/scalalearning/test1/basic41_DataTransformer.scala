package com.example.scalalearning.test1

object DataTransformer {
  def main(args: Array[String]): Unit = {
    println("=== Data Transformer ===")
    println(transform(Map("id" -> "100")))
  }

  private def transform(data: Map[String, String]): Map[String, String] =
    data.view.mapValues(_.toUpperCase).toMap
}
