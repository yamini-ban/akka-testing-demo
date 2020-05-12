name := "akka-testing-demo"

version := "0.1"

scalaVersion := "2.13.2"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.6.5"

libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % "2.6.5" % Test

libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % Test