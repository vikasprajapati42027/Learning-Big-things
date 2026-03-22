package com.example.scalalearning.test2

object basic98_PayloadBalancer {
  def main(args: Array[String]): Unit = {
    println("=== basic98: Payload balancer ===")
    println(balance(List(1,2,3)))
  }

  def balance(payload: List[Int]): Int = payload.sum / payload.size
}
