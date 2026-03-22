package com.example.hdfslearning.test1

object basic27_HdfsAuditLogNote {
  def main(args: Array[String]): Unit = {
    println("HDFS audit logs capture access operations; configure dfs.namenode.audit.log.async for async logging.")
    println("Verify log location (log4j settings) and ensure retention/rotation are set to avoid disk fill.")
  }
}
