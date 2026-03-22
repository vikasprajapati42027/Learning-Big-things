package com.example.sparklearning.test2

import org.apache.spark.SparkFiles
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic34_SparkFilesBroadcast {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic34_SparkFilesBroadcast").master("local[*]").getOrCreate()
    import spark.implicits._

    // create a tiny lookup file and distribute it
    val tmp = java.nio.file.Files.createTempFile("lookup", ".txt")
    java.nio.file.Files.write(tmp, Seq("1,A", "2,B", "3,C").mkString("
").getBytes())

    spark.sparkContext.addFile(tmp.toString)
    val content = scala.io.Source.fromFile(SparkFiles.get(tmp.getFileName.toString)).getLines().toList
    val lookupMap = content.map { line =>
      val Array(k, v) = line.split(","); k.toInt -> v
    }.toMap
    val bc = spark.sparkContext.broadcast(lookupMap)

    val df = spark.range(1, 5).toDF("id").withColumn("label", lit(bc.value.getOrElse(col("id").cast("int"), "?")))
    df.show()

    spark.stop()
  }
}
