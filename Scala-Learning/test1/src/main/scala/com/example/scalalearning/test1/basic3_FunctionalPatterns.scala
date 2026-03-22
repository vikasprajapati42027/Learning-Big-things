package com.example.scalalearning.test1

object FunctionalPatterns {
  def main(args: Array[String]): Unit = {
    println("=== Scala Functional Patterns ===\n")
    demonstrateSealedTraits()        // model state with sealed trait + case objects
    demonstrateTailrecWithTimeout()  // tail-recursive polling with guard
    demonstrateResourceManagement()  // loan pattern for AutoCloseable resources
    demonstrateLazyStreams()         // lazy stream + recursive generation
    demonstrateMonadTransform()      // for-comprehension over Option values
  }

  private def demonstrateSealedTraits(): Unit = {
    println("[sealed trait] domain modeling")
    sealed trait Status
    case object Pending extends Status
    case object Completed extends Status
    case class Failed(reason: String) extends Status

    def describe(status: Status): String = status match {
      case Pending     => "waiting"
      case Completed   => "done"
      case Failed(msg) => s"failed: $msg"
    }

    val statuses = List(Pending, Completed, Failed("timeout"))
    statuses.foreach(s => println(describe(s)))
    println()
  }

  private def demonstrateTailrecWithTimeout(): Unit = {
    println("[tailrec + guard] sample scheduler")
    import scala.annotation.tailrec
    import scala.util.Random

    @tailrec
    def waitForEvent(attempts: Int, deadline: Long): Boolean = {
      if (deadline <= System.currentTimeMillis()) false
      else if (attempts == 0) false
      else {
        val ready = Random.nextBoolean()
        println(s"checked -> $ready")
        if (ready) true else waitForEvent(attempts - 1, deadline)
      }
    }

    val finished = waitForEvent(5, System.currentTimeMillis() + 1000)
    println(s"event ready -> $finished\n")
  }

  private def demonstrateResourceManagement(): Unit = {
    println("[resource] loan pattern")
    def withResource[T](resource: AutoCloseable)(f: AutoCloseable => T): T = {
      try {
        f(resource)
      } finally {
        resource.close()
      }
    }

    class DummyResource extends AutoCloseable {
      def write(value: String): Unit = println(s"writing $value")
      override def close(): Unit = println("closed")
    }

    withResource(new DummyResource) { res =>
      res.write("hello loan pattern")
    }

    println()
  }

  private def demonstrateLazyStreams(): Unit = {
    println("[lazy stream] infinite random feed")
    import scala.util.Random
    lazy val randomNumbers: LazyList[Int] = Random.nextInt(100) #:: randomNumbers.map(_ => Random.nextInt(100))
    randomNumbers.take(3).foreach(n => println(s"stream -> $n"))
    println()
  }

  private def demonstrateMonadTransform(): Unit = {
    println("[for comprehension] nested options")
    val maybeA = Option(2)
    val maybeB = Option(3)
    val sum = for {
      a <- maybeA
      b <- maybeB
    } yield a + b
    println(s"maybe sum -> $sum")
    println()
  }
}
