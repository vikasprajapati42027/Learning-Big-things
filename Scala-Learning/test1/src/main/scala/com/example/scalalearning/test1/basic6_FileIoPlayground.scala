package com.example.scalalearning.test1

import java.nio.file.{Files, Paths, StandardOpenOption}
import java.nio.charset.StandardCharsets
import scala.jdk.CollectionConverters._

object FileIoPlayground {
  def main(args: Array[String]): Unit = {
    println("=== Scala File IO Playground ===\n")
    val path = Paths.get("Scala-Learning/test1/src/main/resources/sample.txt")
    ensureParent(path)  // make sure directory exists
    writeSample(path)   // write initial content
    readSample(path)    // read what was written
    appendSample(path)  // append additional line
    readSample(path)    // read again to see appended text
    cleanUp(path)       // delete temp file
  }

  private def ensureParent(path: java.nio.file.Path): Unit = {
    Files.createDirectories(path.getParent) // create dirs if missing
  }

  private def writeSample(path: java.nio.file.Path): Unit = {
    val lines = List("Scala File IO", "First line", "Second line")
    Files.write(path, lines.asJava, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)
    println(s"written -> ${lines.size} lines")
  }

  private def readSample(path: java.nio.file.Path): Unit = {
    val lines = Files.readAllLines(path, StandardCharsets.UTF_8)
    println(s"read -> ${lines.size} lines")
    lines.forEach(line => println(s"   $line"))
  }

  private def appendSample(path: java.nio.file.Path): Unit = {
    val append = "Appended line"
    Files.write(path, List(append).asJava, StandardCharsets.UTF_8, StandardOpenOption.APPEND)
    println("appended one line")
  }

  private def cleanUp(path: java.nio.file.Path): Unit = {
    Files.deleteIfExists(path)
    println("cleaned up sample file\n")
  }
}
