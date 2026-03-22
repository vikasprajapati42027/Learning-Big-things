package com.example.scalalearning.test1

import scala.util.parsing.combinator.RegexParsers

object ParserCombinatorDemo extends RegexParsers {
  def main(args: Array[String]): Unit = {
    println("=== Scala Parser Combinator Demo ===\n")
    println(parseExpression("1 + 2 * 3"))
    println(parseExpression("(4 + 5) * 2"))
    println(parseKeyValue("key=value"))
    println()
  }

  def expression: Parser[Int] = term ~ rep("+" ~> term | "-" ~> term) ^^ {
    case init ~ tail => (init :: tail).sum
  }

  def term: Parser[Int] = factor ~ rep("*" ~> factor | "/" ~> factor) ^^ {
    case init ~ tail => tail.foldLeft(init)(_ * _)
  }

  def factor: Parser[Int] = wholeNumber ^^ (_.toInt) | "(" ~> expression <~ ")"

  def parseExpression(input: String): String = parseAll(expression, input) match {
    case Success(result, _) => s"expression '$input' -> $result"
    case Failure(msg, _)    => s"failure -> $msg"
    case Error(msg, _)      => s"error -> $msg"
  }

  def keyValue: Parser[(String, String)] = ident ~ "=" ~ ident ^^ {
    case key ~ "=" ~ value => (key, value)
  }

  def parseKeyValue(input: String): String = parseAll(keyValue, input) match {
    case Success(result, _) => s"keyValue '$input' -> $result"
    case Failure(msg, _)    => s"failure -> $msg"
    case Error(msg, _)      => s"error -> $msg"
  }
}
