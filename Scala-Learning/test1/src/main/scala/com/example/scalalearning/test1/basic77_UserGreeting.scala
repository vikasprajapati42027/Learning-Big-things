
        package com.example.scalalearning.test1

        object basic77_UserGreeting {
          def main(args: Array[String]): Unit = {
            println("=== Scala basic77_UserGreeting ===")
            println(greet("Jane"))
          }
+         private def greet(name:String)=s"Hello $name"
        }
