package com.example.scalalearning.test2

object basic23_UnitAware {
  def main(args: Array[String]): Unit = {
    println("=== basic23: Unit-aware math ===")
    val distance = Meters(100)
    val speed = MetersPerSecond(10)
    println(s"time -> ${timeToTravel(distance, speed)}")
  }

  case class Meters(value: Double)
  case class Seconds(value: Double)
  case class MetersPerSecond(value: Double)

  def timeToTravel(distance: Meters, speed: MetersPerSecond): Seconds =
    Seconds(distance.value / speed.value)
}
