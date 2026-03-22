package com.example.hdfslearning.test1

object basic19_HdfsEncryptionZoneNote {
  def main(args: Array[String]): Unit = {
    println("HDFS TDE (encryption zones) requires KMS + EZ setup by admin.")
    println("Commands (admin):")
    println("  hdfs crypto -createZone -keyName mykey -path /secure/path")
    println("  hdfs crypto -listZones")
    println("Client I/O stays transparent; keys never leave KMS, blocks stored encrypted at rest.")
  }
}
