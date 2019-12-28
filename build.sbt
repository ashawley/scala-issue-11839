scalaVersion := "2.13.1"

crossScalaVersions := Seq(
  "2.12.10",
  "2.13.0-M5",
  "2.13.0-pre-d645559",
  "2.13.0-pre-c742cff", // !
  "2.13.0-RC1",         // !
  "2.13.1"              // !
)

scalacOptions in (Compile, doc) += "-Xfatal-warnings"

apiMappings ++= {
  Map(
    scalaInstance.value.libraryJar
      -> url(s"http://www.scala-lang.org/api/${scalaVersion.value}/")
  ) ++ Map(
    file("/modules/java.base")
      -> url("https://docs.oracle.com/en/java/javase/11/docs/api/java.base")
  )
}

resolvers += "scala-integration" at
  "https://scala-ci.typesafe.com/artifactory/scala-integration/"
