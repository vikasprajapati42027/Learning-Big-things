package com.example.scalalearning.test2

import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

object basic48_PayloadSigner {
  def main(args: Array[String]): Unit = {
    println("=== basic48: Payload signer ===")
    println(sign("payload", "secret"))
  }

  def sign(data: String, key: String): String = {
    val mac = Mac.getInstance("HmacSHA256")
    mac.init(new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256"))
    mac.doFinal(data.getBytes("UTF-8")).map(b => f"$b%02x").mkString
  }
}
