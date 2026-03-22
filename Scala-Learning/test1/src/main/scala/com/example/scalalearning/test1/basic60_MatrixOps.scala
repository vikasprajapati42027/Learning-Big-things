package com.example.scalalearning.test1

object MatrixOps {
  def main(args: Array[String]): Unit = {
    println("=== Scala Matrix Ops ===")
    val matrix = Vector(Vector(1,2),Vector(3,4))
    println(transpose(matrix)) // compute transpose of 2d Vector
  }

  private def transpose(matrix: Vector[Vector[Int]]): Vector[Vector[Int]] =
    if(matrix.isEmpty) Vector.empty
    else matrix.head.indices.map(i=>matrix.map(_(i))).toVector
}
