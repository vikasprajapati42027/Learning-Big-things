package com.example.scalalearning.test2

object basic42_ConfigPublisher {
  def main(args: Array[String]): Unit = {
    println("=== basic42: Config publisher ===")
    val publisher = new Publisher
    publisher.subscribe(config => println(s"subscriber got $config"))
    publisher.publish(Map("feature" -> "beta"))
  }

  class Publisher {
    private var subscribers = Vector.empty[Map[String, String] => Unit]
    def subscribe(callback: Map[String, String] => Unit): Unit = subscribers :+= callback
    def publish(config: Map[String, String]): Unit = subscribers.foreach(_.apply(config))
  }
}
