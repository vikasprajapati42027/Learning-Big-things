package com.example.scalalearning.test2

object basic58_DoubleBuffer {
  def main(args: Array[String]): Unit = {
    println("=== basic58: Double buffer ===")
    val buffer = new DoubleBuffer[Int]
    buffer.write(1)
    println(buffer.read())
  }

  class DoubleBuffer[T] {
    private var slotA: Option[T] = None
    private var slotB: Option[T] = None
    def write(value: T): Unit = slotA = slotB.orElse(Some(value))
    def read(): Option[T] = slotA
  }
}
