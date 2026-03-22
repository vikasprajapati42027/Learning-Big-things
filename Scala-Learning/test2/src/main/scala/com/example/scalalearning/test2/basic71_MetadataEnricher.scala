package com.example.scalalearning.test2

object basic71_MetadataEnricher {
  def main(args: Array[String]): Unit = {
    println("=== basic71: Metadata enricher ===")
    println(enrich(Map("id" -> "123")))
  }

  def enrich(data: Map[String, String]): Map[String, String] = data + ("timestamp" -> System.currentTimeMillis.toString)
}
