
        package com.example.scalalearning.test1

        object basic73_PathBuilder {
          def main(args: Array[String]): Unit = {
            println("=== Scala basic73_PathBuilder ===")
            println(buildPath("a","b"))
          }
+         private def buildPath(parts:String*)=parts.mkString("/")
        }
