
        package com.example.scalalearning.test1

        object basic80_CounterFizz {
          def main(args: Array[String]): Unit = {
            println("=== Scala basic80_CounterFizz ===")
            println(counter(5))
          }
+         private def counter(n:Int)=if(n%2==0)"even"else"odd"
        }
