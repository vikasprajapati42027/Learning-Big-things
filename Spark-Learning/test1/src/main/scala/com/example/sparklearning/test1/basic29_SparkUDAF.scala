package com.example.sparklearning.test1

import org.apache.spark.sql.expressions.MutableAggregationBuffer
import org.apache.spark.sql.expressions.UserDefinedAggregateFunction
import org.apache.spark.sql.types._
import org.apache.spark.sql.{Row, SparkSession}

object basic29_SparkUDAF {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic29_SparkUDAF").master("local[*]").getOrCreate()
    import spark.implicits._

    val avgLen = new AvgLengthUdaf
    val df = Seq("aa", "bbb", "c").toDF("word")
    df.select(avgLen(df("word")).as("avg_len")).show()

    spark.stop()
  }

  class AvgLengthUdaf extends UserDefinedAggregateFunction {
    override def inputSchema: StructType = StructType(Seq(StructField("word", StringType)))
    override def bufferSchema: StructType = StructType(Seq(
      StructField("total", LongType),
      StructField("count", LongType)
    ))
    override def dataType: DataType = DoubleType
    override def deterministic: Boolean = true

    override def initialize(buffer: MutableAggregationBuffer): Unit = { buffer(0) = 0L; buffer(1) = 0L }
    override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
      val word = input.getAs[String](0)
      buffer(0) = buffer.getLong(0) + word.length
      buffer(1) = buffer.getLong(1) + 1
    }
    override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
      buffer1(0) = buffer1.getLong(0) + buffer2.getLong(0)
      buffer1(1) = buffer1.getLong(1) + buffer2.getLong(1)
    }
    override def evaluate(buffer: Row): Any = buffer.getLong(0).toDouble / buffer.getLong(1)
  }
}
