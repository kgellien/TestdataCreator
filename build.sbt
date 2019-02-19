name := "TestdataCreator"

organization := "de.gellien"

version := "1.0.0"

scalaVersion := "2.12.8"

scalacOptions ++= Seq("-deprecation", "-unchecked")

libraryDependencies ++= {
  val scalaCheckVersion = "1.14.0"
  Seq(
    "org.scalacheck" %% "scalacheck" % scalaCheckVersion
  )
}
