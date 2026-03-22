package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.udf

object basic65_HiveSessionUdfTempFunction {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic65_HiveSessionUdfTempFunction")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()

    val reverseUdf = udf((s: String) => Option(s).map(_.reverse).orNull)
    spark.udf.register("reverse_udf", reverseUdf)

    spark.sql("SELECT reverse_udf('hive') as reversed, reverse_udf(null) as reversed_null").show()
    spark.stop()
  }
}
