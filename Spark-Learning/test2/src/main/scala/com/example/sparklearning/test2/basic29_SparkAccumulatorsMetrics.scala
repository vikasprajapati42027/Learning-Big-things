package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic29_SparkAccumulatorsMetrics {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic29_SparkAccumulatorsMetrics").master("local[*]").getOrCreate()
    import spark.implicits._

    val acc = spark.sparkContext.longAccumulator("evenCount")
    val bcMap = spark.sparkContext.broadcast(Map(1 -> "A", 2 -> "B"))

    spark.range(0, 10).toDF("id").foreach { row =>
      if (row.getLong(0) % 2 == 0) acc.add(1)
    }

    val enriched = spark.range(1, 5).toDF("id").withColumn("label", lit(bcMap.value.getOrElse(col("id").cast("int"), "?")))
    enriched.show()

    println(s"Accumulator evenCount = ${acc.value}")
    spark.stop()
  }
}
