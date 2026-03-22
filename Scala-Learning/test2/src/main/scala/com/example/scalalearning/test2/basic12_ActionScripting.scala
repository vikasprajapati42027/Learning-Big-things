package com.example.scalalearning.test2

object basic12_ActionScripting {
  def main(args: Array[String]): Unit = {
    println("=== basic12: Action scripting ===")
    val script = Script()
      .add("open")
      .add("write")
      .add("close")
    script.run()
  }

  sealed trait Action { def name: String }
  case object Open extends Action { def name = "open" }
  case object Write extends Action { def name = "write" }
  case object Close extends Action { def name = "close" }

  case class Script(actions: Vector[Action] = Vector.empty) {
    def add(action: Action): Script = copy(actions = actions :+ action)
    def run(): Unit = actions.foreach(a => println(s"action -> ${a.name}"))
  }
}
