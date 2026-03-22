package com.example.scalalearning.test2

object basic11_ValidationPipeline {
  def main(args: Array[String]): Unit = {
    println("=== basic11: Validation pipeline ===")
    val input = Map("email" -> "user@example.com", "age" -> "29")
    runValidation(input) match {
      case Right(user) => println(s"validated -> $user")
      case Left(errors) => println(s"errors -> ${errors.mkString(",")}")
    }
  }

  case class User(email: String, age: Int)

  def runValidation(data: Map[String, String]): Either[List[String], User] = {
    val email = data.get("email").filter(_.contains("@"))
    val age = data.get("age").flatMap(s => util.Try(s.toInt).toOption)
    val errors = List(
      email.toRight("email missing or invalid").swap.toOption,
      age.toRight("age missing or invalid").swap.toOption
    ).flatten

    (email, age, errors) match {
      case (Some(e), Some(a), Nil) => Right(User(e, a))
      case _ => Left(errors)
    }
  }
}
