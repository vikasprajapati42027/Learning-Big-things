
        package com.example.scalalearning.test1

        object basic79_DelayPrint {
          def main(args: Array[String]): Unit = {
            println("=== Scala basic79_DelayPrint ===")
            println(delayed(() => "done"))
          }
+         private def delayed(f:()=>String){println(f())}
        }
