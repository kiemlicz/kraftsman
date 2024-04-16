lazy val root = (project in file("."))
  .enablePlugins(KanikoPlugin, JavaAppPackaging)
  .settings(
    version := "0.1.0",
    scalaVersion := "2.13.11",
  )
