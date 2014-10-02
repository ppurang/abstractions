import sbt._

name := "abstractions"

organization := "org.purang"

scalaVersion := "2.11.2"

libraryDependencies ++=  Seq(
  "org.scalacheck" %% "scalacheck" % "1.11.5"
)

logBuffered := false

scalacOptions ++= Seq("-unchecked",
  "-optimize",
  "-feature",
  "-language:_",
  "-deprecation",
  //"-Xfatal-warnings",
  "-Xlint",
  "-encoding",  "UTF-8",
  "-target:jvm-1.7",
  "-Ywarn-adapted-args",
  "-Ywarn-value-discard",
  "-Xlog-reflective-calls",
  "-Yinline-warnings",
  "-Yclosure-elim",
  "-Yinline",
  "-Xverify")
  
cancelable := true

fork := true

initialCommands += """
    |import goto._
    |import SemigroupOps._
    |import EqualOps._
    |import Sums._
    |
  """.stripMargin
