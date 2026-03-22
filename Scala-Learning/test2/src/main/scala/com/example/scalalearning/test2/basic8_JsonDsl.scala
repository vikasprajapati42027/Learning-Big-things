package com.example.scalalearning.test2

object basic8_JsonDsl {
  def main(args: Array[String]): Unit = {
    println("=== basic8: JSON-ish DSL ===")
    val json = obj(
      "user" -> str("Ada"),
      "active" -> bool(true),
      "scores" -> arr(num(3), num(7), num(11))
    )
    println(json.stringify)
    println("(DSL composes small builders into structured output)")
  }

  sealed trait JsonValue {
    def stringify: String = this match {
      case JsonObject(fields) => fields.map { case (k, v) => s"\"$k\":${v.stringify}" }.mkString("{", ",", "}")
      case JsonArray(items) => items.map(_.stringify).mkString("[", ",", "]")
      case JsonString(value) => s"\"$value\""
      case JsonNumber(value) => value.toString
      case JsonBool(value) => value.toString
    }
  }

  case class JsonObject(fields: Map[String, JsonValue]) extends JsonValue
  case class JsonArray(items: Vector[JsonValue]) extends JsonValue
  case class JsonString(value: String) extends JsonValue
  case class JsonNumber(value: Int) extends JsonValue
  case class JsonBool(value: Boolean) extends JsonValue

  def obj(pairs: (String, JsonValue)*): JsonValue = JsonObject(pairs.toMap)
  def arr(items: JsonValue*): JsonValue = JsonArray(items.toVector)
  def str(value: String): JsonValue = JsonString(value)
  def num(value: Int): JsonValue = JsonNumber(value)
  def bool(value: Boolean): JsonValue = JsonBool(value)
}
