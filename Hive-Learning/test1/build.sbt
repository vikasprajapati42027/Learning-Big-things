name := "hive-learning-test1"

version := "0.1.0"

scalaVersion := "2.12.17"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql"  % "3.4.1" % "provided",
  "org.apache.spark" %% "spark-hive" % "3.4.1" % "provided"
)
