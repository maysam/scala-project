import de.johoop.jacoco4sbt._
import JacocoPlugin._

seq(jacoco.settings : _*)

jacoco.reportFormats in jacoco.Config := Seq(XMLReport("utf-8"), HTMLReport("utf-8"))

scalacOptions ++= Seq("-deprecation")

seq(ScctPlugin.instrumentSettings : _*)

libraryDependencies += "org.scalatest" %% "scalatest" % "1.8" % "test"

libraryDependencies += "junit" % "junit" % "4.10" % "test"

resolvers ++= Seq(
  "Sonatype Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases"
)

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.10.0" % "test"
)
//libraryDependencies ++= Seq("com.jteigen.scalatest" %% "junit4runner" % "1.0-SNAPSHOT" % "test")

libraryDependencies += "org.scalaj" %% "scalaj-time" % "0.6"

resolvers += "Scala Tools Releases" at "http://scala-tools.org/repo-releases/"

resolvers += "Scala Tools Snapshots" at "http://scala-tools.org/repo-snapshots/"

libraryDependencies += "org.scalatest" % "scalatest" % "1.3" % "test"	//	2.0.M5

libraryDependencies ++= Seq(
	"org.specs2" %% "specs2" % "1.12.4-SNAPSHOT" % "test"
)

resolvers ++= Seq("snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
                    "releases"  at "http://oss.sonatype.org/content/repositories/releases")
                    
publishTo := Some(Resolver.file("file",  new File("./maven-repo")))
                    