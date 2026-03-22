package com.example.scalalearning.test2

import java.security.MessageDigest

object basic97_EventSigner {
  def main(args: Array[String]): Unit = {
    println("=== basic97: Event signer ===")
    println(sign("event"))
  }

  def sign(value: String): String = {
    MessageDigest.getInstance("SHA-1").digest(value.getBytes("UTF-8")).map(b => f"$b%02x").mkString
  }
}
