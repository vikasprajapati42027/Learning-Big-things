package com.example.scalalearning.test2

object basic29_EventTrace {
  def main(args: Array[String]): Unit = {
    println("=== basic29: Event trace ===")
    val recorder = new EventRecorder
    recorder.record("start")
    recorder.record("process")
    println(recorder.historyLog)
  }

  class EventRecorder {
    private var history = Vector.empty[String]
    def record(event: String): Unit = history :+= event
    def historyLog: Vector[String] = history
  }
}
