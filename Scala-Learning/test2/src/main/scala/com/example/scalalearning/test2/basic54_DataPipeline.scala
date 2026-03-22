package com.example.scalalearning.test2

object basic54_DataPipeline {
  def main(args: Array[String]): Unit = {
    println("=== basic54: Data pipeline ===")
    println(process(Seq(1,2,3,4)))
  }

  def process(xs: Seq[Int]): Seq[Int] = xs.map(_ * 2).filter(_ % 3 != 0)
}
