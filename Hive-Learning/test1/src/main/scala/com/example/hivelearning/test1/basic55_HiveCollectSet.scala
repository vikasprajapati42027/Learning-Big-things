package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic55_HiveCollectSet {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic55_HiveCollectSet").master("local[*]").enableHiveSupport().getOrCreate()

    spark.sql("CREATE TEMP VIEW v AS SELECT 'alice' as user, 'click' as action UNION ALL SELECT 'alice','view'")
    spark.sql("SELECT user, collect_set(action) as uniq_actions FROM v GROUP BY user").show(false)
    spark.stop()
  }
}
