package com.example.scalalearning.test1

object DataStreaming {
  def main(args: Array[String]): Unit = {
    println("=== Data Streaming Patterns ===\n")
    demonstrateChunkedProcessing()
    demonstrateSlidingAggregation()
    demonstrateAsyncSimulation()
  }

  private def demonstrateChunkedProcessing(): Unit = {
    println("[chunked] process batches")
    val elements = (1 to 20).toList
    elements.grouped(5).foreach(batch => println(s"batch -> ${batch.mkString("[")}"))
    println()
  }

  private def demonstrateSlidingAggregation(): Unit = {
    println("[sliding aggregate] running sums")
    val stream = LazyList.from(1)
    val aggregated = stream.sliding(4).map(window => window.sum).take(5)
    println(s"aggregated -> ${aggregated.toList}")
    println()
  }

  private def demonstrateAsyncSimulation(): Unit = {
    println("[async simulation] Future-like manual")
    def fetchData(id: Int)(onSuccess: Int => Unit): Unit = {
      Thread.sleep(50)
      onSuccess(id * id)
    }
    (1 to 3).foreach(id => fetchData(id)(result => println(s"fetched -> $result")))
    println()
  }
}
