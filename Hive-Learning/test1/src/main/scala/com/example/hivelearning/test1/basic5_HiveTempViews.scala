package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic5_HiveTempViews {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic5_HiveTempViews")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()

    import spark.implicits._

    val df = Seq((1, "local"), (2, "global")).toDF("id", "kind")
    df.createOrReplaceTempView("v_local")
    df.createGlobalTempView("v_global")

    println("Temp view visible in current session:")
    spark.sql("SELECT * FROM v_local").show()

    println("Global temp view uses database global_temp:")
    spark.sql("SELECT * FROM global_temp.v_global").show()

    spark.stop()
  }
}
