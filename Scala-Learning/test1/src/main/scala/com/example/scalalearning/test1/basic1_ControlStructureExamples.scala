package com.example.scalalearning.test1

object ControlStructureExamples {
  def main(args: Array[String]): Unit = {
    println("=== Scala Control Structure Playground ===\n")
    demonstrateIfElse()       // even/odd branching with nested if
    demonstrateForLoops()     // various for-comprehension styles
    demonstrateWhileLoop()    // classic while loop counter
    demonstrateDoWhileLoop()  // do/while always executes once
    demonstrateForeachLoop()  // lambda-driven iteration over Vector
    demonstrateRepeatUntil()  // tail-recursive repeat until pattern
    demonstrateEnhancedFor()  // zipped collections + guarded yield
  }

  private def demonstrateIfElse(): Unit = {
    println("[if/else] Evaluate number parity")
    val number = 42
    val parity = if (number % 2 == 0) "even" else "odd"
    println(s"Number $number is $parity")

    val nested = if (number > 0) {
      if (number < 50) "small positive" else "large positive"
    } else {
      "non-positive"
    }
    println(s"Nested if result: $nested\n")
  }

  private def demonstrateForLoops(): Unit = {
    println("[for] Ranges, collection, guards, and yield")
    for (i <- 1 to 3) println(s"range for -> $i")

    val options = List("apple", "banana", "cherry")
    for (fruit <- options) println(s"collection for -> $fruit")

    for {
      i <- 1 to 5
      if i % 2 == 0
    } println(s"guarded for -> $i")

    val doubled = for (i <- 1 to 4) yield i * 2
    println(s"yielded values: ${doubled.mkString(",")}")
    println()
  }

  private def demonstrateWhileLoop(): Unit = {
    println("[while] Imperative counter")
    var count = 0
    while (count < 3) { // run until counter hits 3
      println(s"while counting -> $count")
      count += 1
    }
    println()
  }

  private def demonstrateDoWhileLoop(): Unit = {
    println("[do/while] Executes once before checking")
    var count = 0
    do { // body executes before condition
      println(s"do/while once -> $count")
      count += 1
    } while (count < 3)
    println()
  }

  private def demonstrateForeachLoop(): Unit = {
    println("[foreach] Lambda-driven iteration")
    val items = Vector("alpha", "beta", "gamma")
    items.foreach(item => println(s"foreach -> $item")) // anonymous function per item
    println()
  }

  private def demonstrateRepeatUntil(): Unit = {
    println("[repeatUntil] Tail-recursive helper")
    def repeatUntil(counter: Int, max: Int): Unit = {
      println(s"repeat until -> $counter")
      if (counter < max) repeatUntil(counter + 1, max) // tail call
    }
    repeatUntil(0, 5)
    println()
  }

  private def demonstrateEnhancedFor(): Unit = {
    println("[enhanced for] Zipped iteration with guards")
    val letters = List('a', 'b', 'c')
    val numbers = List(1, 2, 3)
    for ((letter, number) <- letters.zip(numbers)) {
      println(s"zipped -> $letter:$number") // process paired values
    }

    val filtered = for {
      n <- numbers if n != 2
    } yield n * 10 // yield filtered/processed wrap
    println(s"filtered yield -> [${filtered.mkString(",")}]")
    println()
  }
}
