package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic86_SparkPlanMetrics {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic86_SparkPlanMetrics").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = spark.range(0, 100000).withColumn("g", col("id") % 10)
    val res = df.groupBy("g").agg(sum("id").as("total"))
    res.collect()
    res.explain(true)
    res.queryExecution.executedPlan.metrics.foreach { case (n, m) => println(s"$n -> ${m.value}") }
    spark.stop()
  }
}
