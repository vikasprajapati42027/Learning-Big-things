package com.example.scalalearning.test1

object CollectionsPlayground {
  def main(args: Array[String]): Unit = {
    println("=== Scala Collections Playground ===\n")
    demonstrateSeqOperations()
    demonstrateMapTransform()
    demonstrateSetAndGroup()
    demonstrateStreams()
    demonstrateCustomIterator()
  }

  private def demonstrateSeqOperations(): Unit = {
    println("[Seq operations] map/filter/fold")
    val numbers = (1 to 10).toList
    val evens = numbers.filter(_ % 2 == 0)
    println(s"evens -> $evens")
    val doubled = numbers.map(_ * 2)
    println(s"doubled -> $doubled")
    val sum = numbers.foldLeft(0)(_ + _)
    println(s"sum -> $sum\n")
  }

  private def demonstrateMapTransform(): Unit = {
    println("[Map transform] sliding + zip")
    val data = List("alpha", "beta", "gamma", "delta")
    val zipped = data.zipWithIndex
    println(s"zipped -> $zipped")
    val windows = data.sliding(2).toList
    println(s"sliding -> $windows\n")
  }

  private def demonstrateSetAndGroup(): Unit = {
    println("[Set & grouping] groupBy diar")
    val words = "this is a test of grouping grouping".split(" ").toSeq
    val histogram = words.groupBy(identity).view.mapValues(_.size).toMap
    println(s"histogram -> $histogram")
    val unique = words.toSet
    println(s"unique -> $unique\n")
  }

  private def demonstrateStreams(): Unit = {
    println("[LazyList] infinite fibonacci")
    lazy val fibs: LazyList[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map { case (a, b) => a + b }
    println(s"first 7 -> ${fibs.take(7).toList}\n")
  }

  private def demonstrateCustomIterator(): Unit = {
    println("[Iterator] custom incrementing")
    class Incrementor(start: Int) extends Iterator[Int] {
      private var current = start
      override def hasNext: Boolean = current < start + 5
      override def next(): Int = {
        val value = current
        current += 1
        value
      }
    }
    val iter = new Incrementor(10)
    iter.foreach(value => println(s"iter -> $value"))
    println()
  }
}
