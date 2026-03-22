package com.example.scalalearning.test1

object BasicScalaConcepts {
  def main(args: Array[String]): Unit = {
    println("=== Scala Basic Concepts ===\n")
    demonstrateValues()          // show val vs var
    demonstrateFunctions()       // define and call small functions
    demonstratePatternMatch()    // use pattern matching on different inputs
    demonstrateTuplesAndOptions()// return multiple values and safe division
    demonstrateCollections()     // map/filter/on collections
  }

  private def demonstrateValues(): Unit = {
    println("[values] val vs var")
    val immutable = 10          // never changes
    var mutable = 5             // can mutate later
    mutable += immutable
    println(s"immutable val -> $immutable, mutable var -> $mutable\n")
  }

  private def demonstrateFunctions(): Unit = {
    println("[functions] definition and invocation")
    def greet(name: String): String = s"Hello, $name"
    println(greet("Scala Learner"))

    def computeArea(radius: Double): Double = math.Pi * radius * radius
    println(f"Circle area for R=2.0 -> ${computeArea(2.0)}%.2f\n")
  }

  private def demonstratePatternMatch(): Unit = {
    println("[pattern match] evaluate runtime type")
    def describe(value: Any): String = value match {
      case i: Int if i > 0  => s"positive int $i"
      case s: String        => s"string '$s'"
      case Some(v)          => s"option contains $v"
      case None             => "empty option"
      case _                => "unknown"
    }

    println(describe(42))
    println(describe("pattern"))
    println(describe(Some(3.14)))
    println(describe(None))
    println(describe(Seq.empty[Int]))
    println()
  }

  private def demonstrateTuplesAndOptions(): Unit = {
    println("[tuples & options] return multiple values")
    def splitName(fullName: String): (String, String) = {
      val parts = fullName.split(" ")
      (parts.head, parts.last)
    }

    val (first, last) = splitName("Ada Lovelace")
    println(s"first -> $first, last -> $last")

    def safeDivide(dividend: Int, divisor: Int): Option[Double] =
      if (divisor == 0) None else Some(dividend.toDouble / divisor)

    println(safeDivide(10, 2))
    println(safeDivide(10, 0))
    println()
  }

  private def demonstrateCollections(): Unit = {
    println("[collections] ranges, maps, and for-comprehensions")
    val numbers = (1 to 5).toList
    val doubled = numbers.map(_ * 2)
    println(s"numbers -> $numbers")
    println(s"doubled -> $doubled")

    val lookup = Map("one" -> 1, "two" -> 2)
    println(s"map get -> ${lookup.get("two").getOrElse(0)}") // safe lookup

    val comprehension = for {
      n <- numbers if n % 2 == 0
    } yield n * n
    println(s"even squares -> $comprehension\n")
  }
}
