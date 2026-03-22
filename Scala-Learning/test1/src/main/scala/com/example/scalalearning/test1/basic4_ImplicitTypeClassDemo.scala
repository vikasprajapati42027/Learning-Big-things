package com.example.scalalearning.test1

object ImplicitTypeClassDemo {
  def main(args: Array[String]): Unit = {
    println("=== Scala Implicit Type Class Demo ===\n")
    printUser(User("Ada", 37))
    printUser(User("Grace", 25))

    println("custom formatter ->" + format[Int](42))
    println()
  }

  case class User(name: String, age: Int)

  trait Printable[T] {
    def format(value: T): String
  }

  object PrintableInstances {
    implicit val stringPrintable: Printable[String] = (value: String) => s"STRING($value)"
    implicit val intPrintable: Printable[Int] = (value: Int) => s"INT($value)"
    implicit val userPrintable: Printable[User] = (user: User) => s"User(name=${user.name}, age=${user.age})"
  }

  object PrintableSyntax {
    implicit class PrintOps[T](value: T) {
      def format(implicit printable: Printable[T]): String = printable.format(value)
    }
  }

  import PrintableInstances._
  import PrintableSyntax._

  def printUser(user: User): Unit = {
    println(user.format)
  }

  def format[T](value: T)(implicit printable: Printable[T]): String = printable.format(value)
}
