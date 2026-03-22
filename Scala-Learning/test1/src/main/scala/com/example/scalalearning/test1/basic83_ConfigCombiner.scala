
package com.example.scalalearning.test1

object basic83_ConfigCombiner {
  def main(args: Array[String]): Unit = {
    println("=== Scala basic83_ConfigCombiner ===")
    val base=Map("k"->"v"); val extra=Map("env"->"prod"); println(base++extra)
  }
}
