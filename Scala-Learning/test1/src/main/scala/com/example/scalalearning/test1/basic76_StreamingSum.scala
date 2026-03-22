
        package com.example.scalalearning.test1

        object basic76_StreamingSum {
          def main(args: Array[String]): Unit = {
            println("=== Scala basic76_StreamingSum ===")
            println(streamSum(List(1,2,3)))
          }
+         private def streamSum(nums:List[Int])=nums.scanLeft(0)(_+_)
        }
