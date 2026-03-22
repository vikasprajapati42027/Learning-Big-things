
        package com.example.scalalearning.test1

        object basic78_HeaderBuilder {
          def main(args: Array[String]): Unit = {
            println("=== Scala basic78_HeaderBuilder ===")
            println(buildHeaders(Map("h"->"v")))
          }
+         private def buildHeaders(headers:Map[String,String])=headers.map{case(k,v)=>s"$k:$v"}.mkString("|")
        }
