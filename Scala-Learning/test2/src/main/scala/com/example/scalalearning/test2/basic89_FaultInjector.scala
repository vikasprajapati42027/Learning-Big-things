package com.example.scalalearning.test2

object basic89_FaultInjector {
  def main(args: Array[String]): Unit = {
    println("=== basic89: Fault injector ===")
    println(inject("payload"))
  }

  def inject(data: String): String = s"faulty-$data"
}
