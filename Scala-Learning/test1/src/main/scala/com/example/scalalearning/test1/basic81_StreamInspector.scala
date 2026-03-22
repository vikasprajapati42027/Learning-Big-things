
package com.example.scalalearning.test1

object basic81_StreamInspector {
  def main(args: Array[String]): Unit = {
    println("=== Scala basic81_StreamInspector ===")
    val xs=LazyList.from(1); println(xs.take(3).toList)
  }
}
