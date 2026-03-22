
package com.example.scalalearning.test1

object basic85_SignalMonitor {
  def main(args: Array[String]): Unit = {
    println("=== Scala basic85_SignalMonitor ===")
    val signal=List(0,1,0); println(signal.count(_==1))
  }
}
