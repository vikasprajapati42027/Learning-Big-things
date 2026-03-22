package com.example.scalalearning.test1

object GraphTraversal {
  def main(args: Array[String]): Unit = {
    println("=== Scala Graph Traversal ===\n")
    val graph = Map(
      "A" -> Set("B", "C"),
      "B" -> Set("D"),
      "C" -> Set("D", "E"),
      "D" -> Set("F"),
      "E" -> Set.empty[String],
      "F" -> Set.empty[String]
    )
    println(s"graph -> $graph")
    println(s"reachable from A -> ${dfs(graph, "A")}")
  }

  private def dfs(graph: Map[String, Set[String]], start: String, visited: Set[String] = Set.empty): Set[String] = {
    if (visited.contains(start)) visited // already seen this node
    else {
      val neighbors = graph.getOrElse(start, Set.empty)
      neighbors.foldLeft(visited + start)((acc, next) => dfs(graph, next, acc))
    }
  }
}
