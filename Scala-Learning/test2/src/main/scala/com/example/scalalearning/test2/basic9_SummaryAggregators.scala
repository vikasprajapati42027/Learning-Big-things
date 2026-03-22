package com.example.scalalearning.test2

object basic9_SummaryAggregators {
  def main(args: Array[String]): Unit = {
    println("=== basic9: Summary aggregators ===")
    val events = List(
      Event("orders", 3),
      Event("orders", 7),
      Event("logins", 5),
      Event("orders", 2),
      Event("logins", 4)
    )

    val summary = events
      .groupBy(_.category)
      .map { case (category, group) => category -> group.map(_.value).sum }

    summary.foreach { case (category, total) => println(s"$category -> $total") }
    println("(groupBy + map yield fast aggregation)")
  }

  case class Event(category: String, value: Int)
}
