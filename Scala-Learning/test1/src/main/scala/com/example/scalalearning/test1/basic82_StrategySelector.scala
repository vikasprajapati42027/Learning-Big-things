
package com.example.scalalearning.test1

object basic82_StrategySelector {
  def main(args: Array[String]): Unit = {
    println("=== Scala basic82_StrategySelector ===")
    trait Strategy; case object Fast extends Strategy; case object Slow extends Strategy; def choose(s:Strategy)=s match{case Fast=>"fast";case Slow=>"slow"}; println(choose(Fast))
  }
}
