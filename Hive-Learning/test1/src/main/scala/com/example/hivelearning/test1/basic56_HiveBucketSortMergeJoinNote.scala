package com.example.hivelearning.test1

object basic56_HiveBucketSortMergeJoinNote {
  def main(args: Array[String]): Unit = {
    println("Bucket map join / sort-merge bucket join can speed joins when both tables are bucketed identically.")
    println("Enable: set hive.auto.convert.sortmerge.join=true; ensure same bucket count and bucketing columns.")
  }
}
