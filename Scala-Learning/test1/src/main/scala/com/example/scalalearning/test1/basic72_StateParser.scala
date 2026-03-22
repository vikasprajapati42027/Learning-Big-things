
        package com.example.scalalearning.test1

        object basic72_StateParser {
          def main(args: Array[String]): Unit = {
            println("=== Scala basic72_StateParser ===")
            println(parse("ON"))
          }
+         private def parse(input:String)=input match{case "ON"=>"active";case _=>"idle"}
        }
