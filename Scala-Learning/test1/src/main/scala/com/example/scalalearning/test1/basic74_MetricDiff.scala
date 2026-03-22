
        package com.example.scalalearning.test1

        object basic74_MetricDiff {
          def main(args: Array[String]): Unit = {
            println("=== Scala basic74_MetricDiff ===")
            println(diff(5,3))
          }
+         private def diff(a:Int,b:Int)=a-b
        }
