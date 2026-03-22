package com.example.scalalearning.test1

object ReaderWriterDemo {
  def main(args: Array[String]): Unit = {
    println("=== Scala Reader-Writer Patterns ===\n")
    demonstrateReader()
    demonstrateWriter()
    demonstrateReaderWriter()
  }

  private type Config = Map[String, String]
  private type Logged[A] = (A, List[String])

  private def demonstrateReader(): Unit = {
    println("[Reader] supply config")
    val reader: Config => String = cfg => cfg.getOrElse("app.name", "default")
    val result = reader(Map("app.name" -> "ScalaApp"))
    println(s"reader -> $result")
    println()
  }

  private def demonstrateWriter(): Unit = {
    println("[Writer] collecting logs")
    def writer(value: String): Logged[String] = (value, List(s"logged:$value"))
    val (result, logs) = writer("payload")
    println(s"writer -> $result logs -> $logs")
    println()
  }

  private def tell(msg: String): Logged[Unit] = ((), List(msg))

  private def combine[A](first: Logged[A], second: Logged[_]): Logged[A] =
    (first._1, first._2 ++ second._2)

  private def demonstrateReaderWriter(): Unit = {
    println("[ReaderWriter] combine config + logs")
    def readerWriter(cfg: Config): Logged[String] = {
      val user = cfg.getOrElse("user", "anon")
      val logged = tell(s"read user $user")
      combine((s"user:$user", List(s"constructed user:$user")), logged)
    }
    val (value, logs) = readerWriter(Map("user" -> "mary"))
    println(s"readerWriter -> $value logs -> $logs")
    println()
  }
}
