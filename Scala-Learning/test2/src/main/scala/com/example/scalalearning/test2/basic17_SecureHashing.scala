package com.example.scalalearning.test2

import java.security.MessageDigest

object basic17_SecureHashing {
  def main(args: Array[String]): Unit = {
    println("=== basic17: Secure hashing ===")
    println(hash("scala-learning"))
  }

  def hash(value: String): String = {
    val digest = MessageDigest.getInstance("SHA-256")
    digest.update(value.getBytes("UTF-8"))
    digest.digest().map(b => f"$b%02x").mkString
  }
}
