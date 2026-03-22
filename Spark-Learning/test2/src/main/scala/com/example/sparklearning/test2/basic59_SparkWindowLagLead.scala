package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

object basic59_SparkWindowLagLead {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic59_SparkWindowLagLead").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq(("alice", 1), ("alice", 2), ("alice", 3)).toDF("name", "score")
    val w = Window.partitionBy("name").orderBy("score")
    df.select(col("name"), col("score"), lag("score", 1).over(w).as("prev"), lead("score", 1).over(w).as("next")).show()

    spark.stop()
  }
}
