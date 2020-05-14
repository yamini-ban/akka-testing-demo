name := "akka-testing-demo"

version := "0.1"

scalaVersion := "2.13.2"

val akkaVer = "2.6.5"
val logbackVer = "1.2.3"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % akkaVer

libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % akkaVer % Test

libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % Test

libraryDependencies += "com.typesafe.akka" %% "akka-slf4j" % akkaVer

libraryDependencies += "ch.qos.logback" % "logback-classic" % logbackVer
