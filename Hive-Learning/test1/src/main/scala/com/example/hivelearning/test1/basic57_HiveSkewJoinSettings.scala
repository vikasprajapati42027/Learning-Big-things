package com.example.hivelearning.test1

object basic57_HiveSkewJoinSettings {
  def main(args: Array[String]): Unit = {
    println("Skew join settings:")
    println("  set hive.optimize.skewjoin=true;")
    println("  set hive.skewjoin.key=100000; # rows to consider skewed")
    println("These split heavy keys to separate map-reduce paths; Spark handles skew via AQE instead.")
  }
}
