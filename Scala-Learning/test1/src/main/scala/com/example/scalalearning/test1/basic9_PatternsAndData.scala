package com.example.scalalearning.test1

object PatternsAndData {
  def main(args: Array[String]): Unit = {
    println("=== Scala Patterns & Data ===\n")
    demonstrateOptionZip()           // combine options safely
    demonstrateMapFilterReduce()     // pipeline with map/filter/reduce
    demonstrateLazyEvaluationChain() // use view to delay computation
    demonstrateCaseClassCopy()       // copy case class immutably
  }

  private def demonstrateOptionZip(): Unit = {
    println("[Option zip] combine multiple options")
    val maybeName = Option("Scala")
    val maybeVersion = Option(3.4)
    val zipped = maybeName.zip(maybeVersion)
    println(s"zipped option -> $zipped")
    val combined = (maybeName zip maybeVersion).map { case (n, v) => s"$n $v" }
    println(s"combined -> $combined\n")
  }

  private def demonstrateMapFilterReduce(): Unit = {
    println("[map/filter/reduce] data pipeline")
    val readings = Seq(21, 18, 23, 17, 22)
    val normalized = readings.map(_ + 3)
    val filtered = normalized.filter(_ >= 20)
    val reduced = filtered.reduceOption(_ + _) // sum window if defined
    println(s"normalized -> $normalized")
    println(s"filtered -> $filtered")
    println(s"reduced -> $reduced\n")
  }

  private def demonstrateLazyEvaluationChain(): Unit = {
    println("[Lazy evaluation] chained `view` operations")
    val values = (1 to 5).view.map(_ * 2).filter(_ % 3 != 0)
    println(s"lazy view -> ${values.toList}\n")
  }

  private def demonstrateCaseClassCopy(): Unit = {
    println("[case class copy] incremental updates")
    case class Config(env: String, retries: Int)
    val prod = Config("prod", 3)
    val debug = prod.copy(env = "debug", retries = prod.retries + 1) // new copy with updated fields
    println(s"prod -> $prod")
    println(s"debug -> $debug\n")
  }
}
