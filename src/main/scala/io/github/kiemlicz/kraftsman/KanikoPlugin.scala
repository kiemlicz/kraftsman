package io.github.kiemlicz.kraftsman

import com.typesafe.sbt.packager.Keys.{dockerExecCommand, stage}
import com.typesafe.sbt.packager.docker.DockerPlugin
import com.typesafe.sbt.packager.docker.DockerPlugin.autoImport.Docker
import sbt.{AutoPlugin, Configuration, Setting, inConfig, taskKey}

object KanikoPlugin extends AutoPlugin {
  override def trigger = noTrigger

  override def requires = DockerPlugin

  object autoImport {
    lazy val kanikoPublishLocal = taskKey[Unit]("Builds a Docker image using Kaniko POC")
  }

  import autoImport.*

  lazy val baseKanikoSettings: Seq[Setting[_]] = Seq(
    kanikoPublishLocal := {
      val st = stage.value
      // run_in_docker
    }
  )

  override def projectConfigurations: Seq[Configuration] = Seq(Docker)

  override lazy val projectSettings: Seq[Setting[_]] =
    inConfig(Docker)(baseKanikoSettings)
}
