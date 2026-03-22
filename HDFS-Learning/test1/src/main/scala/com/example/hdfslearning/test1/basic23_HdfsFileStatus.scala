package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
import java.text.SimpleDateFormat

object basic23_HdfsFileStatus {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val path = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/people_parquet")
    val fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    fs.listStatus(path).foreach { st =>
      println(s"${st.getPath} | size=${st.getLen} | rep=${st.getReplication} | perm=${st.getPermission} | mod=${fmt.format(st.getModificationTime)}")
    }
  }
}
