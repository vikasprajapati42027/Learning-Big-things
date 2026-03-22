package com.example.scalalearning.test1

object StringProcessing {
  def main(args: Array[String]): Unit = {
    println("=== Scala String Processing ===\n")
    demonstrateMultiline()
    demonstrateRegex()
    demonstrateInterpolation()
    demonstrateSplitter()
  }

  private def demonstrateMultiline(): Unit = {
    println("[multiline] stripMargin")
    val poem = """
                 |Roses are red
                 |Violets are blue
                 |Scala is expressive
                 |And so are you
                 |""".stripMargin
    println(poem)
  }

  private def demonstrateRegex(): Unit = {
    println("[regex] name extraction")
    val pattern = "([A-Za-z]+)\s([A-Za-z]+)".r
    val result = "Ada Lovelace" match {
      case pattern(first, last) => s"first=$first, last=$last"
      case _ => "no match"
    }
    println(result)
  }

  private def demonstrateInterpolation(): Unit = {
    println("[interpolation] formatted output")
    val language = "Scala"
    val version = 3.4
    println(f"Language $language%s, version $version%1.1f")
  }

  private def demonstrateSplitter(): Unit = {
    println("[split] custom delimiters")
    val csv = "red|green|blue"
    val items = csv.split("\\|")
    items.foreach(item => println(s"item -> $item"))
  }
}
