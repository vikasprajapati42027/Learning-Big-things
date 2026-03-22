package com.example.scalalearning.test2

object basic100_StateBlueprint {
  def main(args: Array[String]): Unit = {
    println("=== basic100: State blueprint ===")
    println(Blueprint("init").describe)
  }

  case class Blueprint(stage: String) {
    def describe: String = s"stage -> $stage"
  }
}
