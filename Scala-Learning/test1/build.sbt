ThisBuild / scalaVersion := "2.13.12"
ThisBuild / version := "0.1.0"

lazy val root = (project in file(".")).settings(
  name := "scala-control-examples",
  scalaVersion := "2.13.12"
)

libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "2.1.1"
