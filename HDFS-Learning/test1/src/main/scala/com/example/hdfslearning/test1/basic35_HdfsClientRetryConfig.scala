package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration

object basic35_HdfsClientRetryConfig {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val retries = conf.getInt("dfs.client.retry.policy.enabled", 1)
    val sleep = conf.get("dfs.client.retry.policy.spec", "null")
    println(s"Client retry enabled=$retries policySpec=$sleep")
    println("Tune dfs.client.retry.policy.spec (e.g., '2000,10,60000,10') for transient NN issues.")
  }
}
