package com.example.scalalearning.test1

object SensorCheck {
  def main(args: Array[String]): Unit = {
    val sensors = Map("temp" -> 42.5, "pressure" -> 101.3)
    println("=== Sensor Check ===")
    sensors.foreach { case (name, value) => println(s"$name -> ${check(value)}") }
  }

  private def check(value: Double): String =
    if (value > 100) "alert" else "ok" // simple thresholding
}
