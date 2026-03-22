package com.example.scalalearning.test2

object basic41_StreamSampler {
  def main(args: Array[String]): Unit = {
    println("=== basic41: Stream sampler ===")
    val source = LazyList.from(1)
    source.take(10).zipWithIndex.foreach { case (value, idx) =>
      if (idx % 3 == 0) println(s"sample[$idx] -> $value")
    }
  }
}
