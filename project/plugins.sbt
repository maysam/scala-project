scalaVersion := "2.9.1"

resolvers ++= Seq(
  Resolver.url("scalasbt", new URL("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns),
  "dropbox sdk" at "http://jberkel.github.com/sbt-dropbox-plugin/releases",
  "Scala-Tools Snapshots Repository" at "http://oss.sonatype.org/content/groups/scala-tools"
)

libraryDependencies ++= Seq(
  "org.jacoco" % "org.jacoco.core" % "0.5.9.201207300726" artifacts(Artifact("org.jacoco.core", "jar", "jar")),
  "org.jacoco" % "org.jacoco.report" % "0.5.9.201207300726" artifacts(Artifact("org.jacoco.report", "jar", "jar")))

addSbtPlugin("de.johoop" % "jacoco4sbt" % "1.2.2")

addSbtPlugin("org.scala-sbt" % "sbt-dropbox-plugin" % "0.1.0")