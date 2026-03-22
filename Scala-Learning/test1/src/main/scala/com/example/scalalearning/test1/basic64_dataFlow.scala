package com.example.scalalearning.test1

object basic64_dataFlow {
  case class Record(id: Int, value: Double)
  def main(args: Array[String]): Unit = {
    println("=== Scala basic64_dataFlow ===")
    val pipeline = List(Record(1, 10.0), Record(2, 20.0))
    pipeline.foreach(r => println(process(r)))
  }

  private def process(record: Record): Record = record.copy(value = record.value * 1.1)
}
