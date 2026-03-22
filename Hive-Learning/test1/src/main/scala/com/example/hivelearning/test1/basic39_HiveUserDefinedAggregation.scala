package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.MutableAggregationBuffer
import org.apache.spark.sql.expressions.UserDefinedAggregateFunction
import org.apache.spark.sql.types._

object basic39_HiveUserDefinedAggregation {

  object AvgAgeUDAF extends UserDefinedAggregateFunction {
    def inputSchema: StructType = StructType(StructField("age", IntegerType) :: Nil)
    def bufferSchema: StructType = StructType(StructField("sum", LongType) :: StructField("count", LongType) :: Nil)
    def dataType: DataType = DoubleType
    def deterministic: Boolean = true
    def initialize(buffer: MutableAggregationBuffer): Unit = { buffer(0) = 0L; buffer(1) = 0L }
    def update(buffer: MutableAggregationBuffer, input: org.apache.spark.sql.Row): Unit = {
      if (!input.isNullAt(0)) {
        buffer(0) = buffer.getLong(0) + input.getInt(0)
        buffer(1) = buffer.getLong(1) + 1
      }
    }
    def merge(buffer1: MutableAggregationBuffer, buffer2: org.apache.spark.sql.Row): Unit = {
      buffer1(0) = buffer1.getLong(0) + buffer2.getLong(0)
      buffer1(1) = buffer1.getLong(1) + buffer2.getLong(1)
    }
    def evaluate(buffer: org.apache.spark.sql.Row): Any = if (buffer.getLong(1) == 0) null else buffer.getLong(0).toDouble / buffer.getLong(1)
  }

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic39_HiveUserDefinedAggregation")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()

    spark.udf.register("avg_age_udaf", AvgAgeUDAF)
    import spark.implicits._
    Seq(("alice", 30), ("bob", 20)).toDF("name", "age").createOrReplaceTempView("udaf_people")

    spark.sql("SELECT avg_age_udaf(age) as avg_age FROM udaf_people").show()
    spark.stop()
  }
}
