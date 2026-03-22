package com.example.scalalearning.test2

object basic7_TypeclassOps {
  def main(args: Array[String]): Unit = {
    println("=== basic7: Typeclass helpers ===")
    println(render(42))
    println(render(Person("Ada", Developer)))
  }

  sealed trait Role
  case object Developer extends Role
  case object Architect extends Role

  case class Person(name: String, role: Role)

  trait Renderable[A] {
    def render(value: A): String
  }

  object Renderable {
    def apply[A](implicit instance: Renderable[A]): Renderable[A] = instance

    implicit val intRenderable: Renderable[Int] = (value: Int) => s"int($value)"
    implicit val personRenderable: Renderable[Person] = person => s"${person.name} -> ${person.role}"
  }

  def render[A: Renderable](value: A): String = Renderable[A].render(value)
}
