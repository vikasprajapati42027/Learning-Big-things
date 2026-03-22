
        package com.example.scalalearning.test1

        object basic75_FlagCheck {
          def main(args: Array[String]): Unit = {
            println("=== Scala basic75_FlagCheck ===")
            println(isFlagSet(true))
          }
+         private def isFlagSet(flag:Boolean)=if(flag)"on"else"off"
        }
