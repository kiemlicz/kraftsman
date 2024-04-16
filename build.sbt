import sbt.Keys.{pomIncludeRepository, publishMavenStyle, publishTo}

lazy val root = (project in file("."))
  .enablePlugins(SbtPlugin, SemVerPlugin)
  .settings(
    name := "kraftsman",
    homepage := Some(url("https://github.com/kiemlicz/kraftsman")),
    organization := "io.github.kiemlicz",
    organizationHomepage := Some(url("https://github.com/kiemlicz")),
    description := "SBT Kaniko plugin",
    licenses += "The MIT License" -> url("https://opensource.org/licenses/MIT"),
    developers := List(
      Developer(
        id = "kiemlicz",
        name = "Stanley",
        email = "stanislaw.dev@gmail.com",
        url = url("https://github.com/kiemlicz")
      )
    ),
    javacOptions ++= Seq("-source", "17"),
    //don't specify scalaVersion for plugins (sbt is built for Scala 2.12 only)
    scalacOptions ++= Seq(
      "-encoding", "utf8",
      "-deprecation",
      "-unchecked",
      "-Xlint",
      "-feature",
      "-language:postfixOps",
      "-Xfatal-warnings",
      "-Xsource:3"
    ),
    resolvers += "Sonatype releases".at("https://oss.sonatype.org/content/repositories/releases/"),
    libraryDependencies ++= Seq(
      "com.github.sbt" % "sbt-native-packager_2.12_1.0" % "1.10.0",
      "org.scalatest" %% "scalatest" % "3.2.10" % "test"
    ),
    scriptedLaunchOpts := scriptedLaunchOpts.value ++ Seq("-Xmx1024M", "-Dplugin.version=" + version.value),
    scriptedBufferLog := true,
    scriptedBatchExecution := true,
    scriptedParallelInstances := java.lang.Runtime.getRuntime.availableProcessors(),
    //    useCoursier:=false, //https://youtrack.jetbrains.com/issue/SCL-17825
  )