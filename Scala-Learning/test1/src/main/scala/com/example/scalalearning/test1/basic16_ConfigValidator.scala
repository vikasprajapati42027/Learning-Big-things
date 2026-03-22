package com.example.scalalearning.test1

object ConfigValidator {
  def main(args: Array[String]): Unit = {
    println("=== Scala Config Validator ===\n")
    val config = Map("host" -> "localhost", "port" -> "8080")
    println(validate(config))
  }

  private def validate(cfg: Map[String, String]): Either[String, Config] = for {
    host <- cfg.get("host").toRight("host missing")
    portString <- cfg.get("port").toRight("port missing")
    port <- Either.catchOnly[NumberFormatException](portString.toInt).left.map(_ => "port not number")
  } yield Config(host, port)

  private case class Config(host: String, port: Int)
}
