name := "TestdataCreator"

organization := "de.gellien"

version := "1.0.1"

scalaVersion := "2.13.4"

scalacOptions ++= Seq("-deprecation", "-unchecked")

libraryDependencies ++= {
  val scalaCheckVersion = "1.14.1"
  Seq(
    "org.scalacheck" %% "scalacheck" % scalaCheckVersion
  )
}
