package com.example.scalalearning.test1

object UrlNormalizer {
  def main(args: Array[String]): Unit = {
    println("=== Scala URL Normalizer ===")
    println(normalize("//example.com///path"))
  }

  private def normalize(url: String): String = url.replaceAll("/+","/").stripSuffix("/") // collapse slashes
}
