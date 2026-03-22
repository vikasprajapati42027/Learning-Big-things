package com.example.hivelearning.test1

object basic48_HiveMergeSmallFilesNote {
  def main(args: Array[String]): Unit = {
    println("To mitigate small files in Hive outputs:")
    println("  set hive.merge.smallfiles.avgsize=256000000;")
    println("  set hive.merge.mapfiles=true; set hive.merge.mapredfiles=true;")
    println("  Use Hive/Tez/Spark coalesce/repartition before write when feasible.")
  }
}
