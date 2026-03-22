package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic75_SparkJoinOrder {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic75_SparkJoinOrder")
      .master("local[*]")
      .config("spark.sql.cbo.enabled", "true")
      .config("spark.sql.cbo.joinReorder.enabled", "true")
      .getOrCreate()
    import spark.implicits._

    val a = spark.range(0, 1000).withColumn("k", col("id") % 10)
    val b = spark.range(0, 100).withColumn("k", col("id") % 10)
    val c = spark.range(0, 10).withColumn("k", col("id") % 10)

    a.createOrReplaceTempView("a"); b.createOrReplaceTempView("b"); c.createOrReplaceTempView("c")
    spark.sql("ANALYZE TABLE a COMPUTE STATISTICS")
    spark.sql("ANALYZE TABLE b COMPUTE STATISTICS")
    spark.sql("ANALYZE TABLE c COMPUTE STATISTICS")

    spark.sql("select * from a join b using(k) join c using(k)").explain(true)
    spark.stop()
  }
}
