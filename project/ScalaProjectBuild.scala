import sbt._
import sbt.Keys._

import sbtdropbox.Dropbox
import sbtdropbox.Dropbox.DropboxKeys._


object ScalaProjectBuild extends Build {

  lazy val scalaProject = Project(
    id = "scala-project",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "Scala Project",
      organization := "org.example",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.9.2"
      // add other settings here
    )
  )
  val junit = "junit" % "junit" % "4.8.1"    
  val scalatest = "org.scalatest" % "scalatest" % "1.2" 
  val myproject = Project("scala-project", file("."), settings = Dropbox.settings ++ Seq(
    // your settings
    dropboxFiles  := Seq(new File("a.txt")), // you can also reference tasks producing files here
    dropboxFolder := "someFolder",  
    dropboxAppKey := ("b849xxzf7z0fv3w", "ffizabcs5cu72oj")    // obtain one from https://www.dropbox.com/developers
  ))

}

