package com.example.scalalearning.test2

object basic38_CustomExceptions {
  def main(args: Array[String]): Unit = {
    println("=== basic38: Custom exceptions ===")
    try throw new DomainError("bad input")
    catch {
      case DomainError(msg) => println(s"caught -> $msg")
    }
  }

  case class DomainError(message: String) extends Exception(message)
  object DomainError {
    def unapply(ex: Throwable): Option[String] = ex match {
      case DomainError(msg) => Some(msg)
      case _ => None
    }
  }
}
