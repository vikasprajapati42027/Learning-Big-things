package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FSDataInputStream, FSDataOutputStream, FileSystem, Path}
import org.apache.spark.sql.SparkSession

object basic2_HdfsFsOps {
  def main(args: Array[String]): Unit = {
    // Use Spark to inherit Hadoop configuration, then work with FileSystem directly.
    val spark = SparkSession.builder()
      .appName("basic2_HdfsFsOps")
      .master("local[*]")
      .getOrCreate()

    val conf: Configuration = spark.sparkContext.hadoopConfiguration
    val fs = FileSystem.get(conf)

    val base = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/fsops")
    val file = new Path(base, "hello.txt")

    // Ensure directory exists
    fs.mkdirs(base)

    // Write a small text file
    val out: FSDataOutputStream = fs.create(file, true)
    out.writeUTF("hello hdfs via FileSystem API\nsecond line\n")
    out.close()

    // List files
    println("Listing directory:")
    fs.listStatus(base).foreach(s => println(s"${s.getPath} size=${s.getLen}"))

    // Read file back
    val in: FSDataInputStream = fs.open(file)
    println("File contents:")
    println(in.readUTF())
    in.close()

    spark.stop()
  }
}
