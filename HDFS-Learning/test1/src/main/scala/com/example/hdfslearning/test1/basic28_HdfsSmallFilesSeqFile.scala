package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.hadoop.io.{IntWritable, SequenceFile, Text}

object basic28_HdfsSmallFilesSeqFile {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val path = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/seqfiles/packed.seq")

    val writer = SequenceFile.createWriter(conf,
      SequenceFile.Writer.file(path),
      SequenceFile.Writer.keyClass(classOf[IntWritable]),
      SequenceFile.Writer.valueClass(classOf[Text]))

    (1 to 5).foreach { i =>
      writer.append(new IntWritable(i), new Text(s"record-$i"))
    }
    writer.close()
    println(s"Wrote SequenceFile to $path to mitigate small files problem.")
  }
}
