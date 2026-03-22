package com.example.hdfslearning.test1

object basic39_HdfsQuotaViolationNote {
  def main(args: Array[String]): Unit = {
    println("Quota violations block writes when name-space or space quotas exceed limits.")
    println("Check with hdfs dfs -count -q /path and fsck; adjust via dfsadmin -clrQuota/-clrSpaceQuota.")
  }
}
