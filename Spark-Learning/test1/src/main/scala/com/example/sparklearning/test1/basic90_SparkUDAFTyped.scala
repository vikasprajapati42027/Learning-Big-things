package com.example.sparklearning.test1

import org.apache.spark.sql.{Encoder, Encoders, SparkSession}
import org.apache.spark.sql.expressions.Aggregator

object basic90_SparkUDAFTyped {
  case class Input(len: Int)
  case class SumCount(sum: Long, count: Long)

  object AvgLenAgg extends Aggregator[Input, SumCount, Double] {
    def zero: SumCount = SumCount(0L, 0L)
    def reduce(b: SumCount, a: Input): SumCount = SumCount(b.sum + a.len, b.count + 1)
    def merge(b1: SumCount, b2: SumCount): SumCount = SumCount(b1.sum + b2.sum, b1.count + b2.count)
    def finish(reduction: SumCount): Double = reduction.sum.toDouble / reduction.count
    def bufferEncoder: Encoder[SumCount] = Encoders.product
    def outputEncoder: Encoder[Double] = Encoders.scalaDouble
  }

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic90_SparkUDAFTyped").master("local[*]").getOrCreate()
    import spark.implicits._

    val ds = Seq("one", "three", "seven").map(s => Input(s.length)).toDS()
    ds.select(AvgLenAgg.toColumn).show()

    spark.stop()
  }
}
