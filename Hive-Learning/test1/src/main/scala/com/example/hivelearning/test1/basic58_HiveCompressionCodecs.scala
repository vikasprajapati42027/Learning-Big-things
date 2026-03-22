package com.example.hivelearning.test1

object basic58_HiveCompressionCodecs {
  def main(args: Array[String]): Unit = {
    println("Common Hive codecs:")
    println("  SET hive.exec.compress.output=true;")
    println("  SET mapred.output.compression.codec=org.apache.hadoop.io.compress.SnappyCodec;")
    println("  For ORC/Parquet: set orc.compress=ZLIB/SNAPPY; parquet.compression=SNAPPY/GZIP/LZ4.")
  }
}
