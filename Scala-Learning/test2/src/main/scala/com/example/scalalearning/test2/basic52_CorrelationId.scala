package com.example.scalalearning.test2

object basic52_CorrelationId {
  private val correlation = new ThreadLocal[String]()
  def main(args: Array[String]): Unit = {
    set("req-123")
    println(get())
  }

  def set(value: String): Unit = correlation.set(value)
  def get(): String = correlation.get()
}
