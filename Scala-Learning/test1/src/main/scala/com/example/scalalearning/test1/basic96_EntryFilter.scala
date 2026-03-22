
package com.example.scalalearning.test1

object basic96_EntryFilter {
  def main(args: Array[String]): Unit = {
    println("=== Scala basic96_EntryFilter ===")
    println(Map("a"->1,"b"->2).filter(_._2>1)) // filter map entries where value>1
  }
}
