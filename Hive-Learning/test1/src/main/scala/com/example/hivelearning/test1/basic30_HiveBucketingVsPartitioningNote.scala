package com.example.hivelearning.test1

object basic30_HiveBucketingVsPartitioningNote {
  def main(args: Array[String]): Unit = {
    println("Partitioning reduces data scanned via directory pruning; bucketing improves join performance by co-locating keys.")
    println("Choose partition columns with low/moderate cardinality; use bucketing for high-cardinality join keys.")
    println("Spark supports bucketing writes/reads, but enforcement requires setting spark.sql.sources.bucketing.enabled.")
  }
}
