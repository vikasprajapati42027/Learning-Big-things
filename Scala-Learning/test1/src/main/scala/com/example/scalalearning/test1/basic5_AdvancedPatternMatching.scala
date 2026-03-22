package com.example.scalalearning.test1

object AdvancedPatternMatching {
  def main(args: Array[String]): Unit = {
    println("=== Scala Advanced Pattern Matching ===\n")
    demonstrateSequencePattern()
    demonstrateInfixEnums()
    demonstrateGuardedPatterns()
    demonstrateSnakeCaseExtractor()
  }

  private def demonstrateSequencePattern(): Unit = {
    println("[sequence] head/tail match")
    val routes = List("home", "user", "profile")
    routes match {
      case first :: second :: Nil => println(s"two segments -> $first, $second")
      case first :: rest => println(s"first -> $first, rest -> $rest")
      case Nil => println("empty route")
    }
    println()
  }

  private def demonstrateInfixEnums(): Unit = {
    println("[infix] sealed trait pairs")
    sealed trait Relation
    case class Connection[A, B](left: A, right: B) extends Relation

    val relation: Relation = Connection("nodeA", "nodeB")
    relation match {
      case left Connection right => println(s"infix match -> $left <-> $right")
      case _ => println("no relation")
    }
    println()
  }

  private def demonstrateGuardedPatterns(): Unit = {
    println("[guards] conditional match")
    def describe(value: Int): String = value match {
      case v if v % 15 == 0 => "fizzbuzz"
      case v if v % 5 == 0 => "buzz"
      case v if v % 3 == 0 => "fizz"
      case _ => "plain"
    }
    println(describe(5))
    println(describe(9))
    println()
  }

  private object SnakeCase {
    def unapply(input: String): Option[(String, String)] = {
      val parts = input.split("_")
      if (parts.length == 2) Some((parts(0), parts(1))) else None
    }
  }

  private def demonstrateSnakeCaseExtractor(): Unit = {
    println("[extractor] snake_case split")
    "scala_lang" match {
      case SnakeCase(first, second) => println(s"snake -> $first and $second")
      case other => println(s"no snake -> $other")
    }
    println()
  }
}
