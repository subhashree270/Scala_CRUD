ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.4"

lazy val root = (project in file("."))
  .settings(
    name := "ScalaSampleProject"
  )
libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "8.0.33", // MySQL connector
  "com.typesafe" % "config" % "1.4.2", // Typesafe config
  "org.scalatest" %% "scalatest" % "3.2.18" % Test
//  "com.typesafe.slick" %% "slick" % "3.5.0",
//  "org.postgresql" % "postgresql" % "42.7.3",
//  "com.typesafe.slick" %% "slick-hikaricp" % "3.5.1",
//  "com.github.tminglei" %% "slick-pg" % "0.22.2",
//  "com.github.tminglei" %% "slick-pg_play-json" % "0.22.2"
)