package com.example.scalalearning.test2

object basic2_FunctionToolkit {
  def main(args: Array[String]): Unit = {
    println("=== basic2: Scala Function Toolkit ===\n")
    demonstrateCurrying()
    demonstrateNamedDefaults()
    demonstrateVarargsAndByName()
    demonstrateClosures()
    demonstrateExtractor()
    demonstrateDslBuilder()
  }

  private def demonstrateCurrying(): Unit = {
    println("[currying] compute volume")
    def curryMultiply(x: Int)(y: Int)(z: Int): Int = x * y * z
    val partial = curryMultiply(2)(3)
    println(s"volume -> ${partial(4)}")
    println()
  }

  private def demonstrateNamedDefaults(): Unit = {
    println("[named/defaults] friendly message")
    def withDefaults(prefix: String = "Hello", name: String = "World", suffix: String = "!"): String = s"$prefix, $name$suffix"
    println(withDefaults(name = "Scala", suffix = "!!!"))
    println()
  }

  private def demonstrateVarargsAndByName(): Unit = {
    println("[varargs + by-name] logging")
    def logRun(message: String*)(block: => Unit): Unit = {
      println(s"log start -> ${message.mkString(", ")}")
      block
      println(s"log end -> ${message.drop(1).mkString(",")}")
    }

    logRun("Phase1", "Phase2") {
      println("running block")
    }
    println()
  }

  private def demonstrateClosures(): Unit = {
    println("[closure] tracker")
    def tracker(initial: Int): Int => Int = {
      var state = initial
      (delta: Int) => {
        state += delta
        state
      }
    }
    val track = tracker(0)
    println(track(5))
    println(track(-2))
    println()
  }

  private object ExtractorExamples {
    def unapply(path: String): Option[(String, String)] = {
      val parts = path.split("/").filter(_.nonEmpty)
      if (parts.length >= 2) Some((parts.init.mkString("/"), parts.last)) else None
    }
  }

  private def demonstrateExtractor(): Unit = {
    println("[extractor] path partition")
    "home/user/docs" match {
      case ExtractorExamples(directory, file) => println(s"directory=$directory, file=$file")
      case other => println(s"no match -> $other")
    }
    println()
  }

  private def demonstrateDslBuilder(): Unit = {
    println("[builder] chaining via this.type")
    class PathBuilder(private var segments: Vector[String] = Vector.empty) {
      def add(segment: String): PathBuilder = {
        segments :+= segment
        this
      }
      def addSegment(segment: String): this.type = {
        segments :+= segment
        this
      }
      def build: String = segments.mkString("/")
    }

    val builder = new PathBuilder()
    println(builder.add("tmp").add("scala").addSegment("test").build)
    println()
  }
}
