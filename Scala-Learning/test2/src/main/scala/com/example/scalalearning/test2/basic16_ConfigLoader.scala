package com.example.scalalearning.test2

object basic16_ConfigLoader {
  def main(args: Array[String]): Unit = {
    println("=== basic16: Config loader ===")
    val settings = load(Map("host" -> "127.0.0.1", "port" -> "9000"))
    println(settings)
  }

  case class Config(host: String, port: Int)

  def load(data: Map[String, String]): Option[Config] = for {
    host <- data.get("host")
    port <- data.get("port").flatMap(p => util.Try(p.toInt).toOption)
  } yield Config(host, port)
}
