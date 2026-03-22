package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{ContentSummary, FileSystem, Path}

object basic10_HdfsQuotaInfo {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val dir = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/quota")
    fs.mkdirs(dir)

    val summary: ContentSummary = fs.getContentSummary(dir)
    println(s"Content summary for $dir: space=${summary.getSpaceConsumed} files=${summary.getFileCount} dirs=${summary.getDirectoryCount}")
    println("To set quotas (requires admin):")
    println(s"  hdfs dfsadmin -setQuota 1000 ${dir.toString}")
    println(s"  hdfs dfsadmin -setSpaceQuota 1g ${dir.toString}")
  }
}
