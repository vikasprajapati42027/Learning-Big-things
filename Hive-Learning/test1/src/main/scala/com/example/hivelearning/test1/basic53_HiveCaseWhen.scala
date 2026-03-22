package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic53_HiveCaseWhen {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic53_HiveCaseWhen").master("local[*]").enableHiveSupport().getOrCreate()

    spark.sql("SELECT id, CASE WHEN id % 2 = 0 THEN 'even' ELSE 'odd' END as parity FROM range(0,5)").show()
    spark.stop()
  }
}
