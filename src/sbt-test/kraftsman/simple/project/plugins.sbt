sys.props.get("plugin.version") match {
  case Some(v) => addSbtPlugin("io.github.kiemlicz" % "kraftsman" % v)
  case _ => sys.error(
    """|The system property 'plugin.version' is not defined.
       |Specify this property using the scriptedLaunchOpts -D.""".stripMargin
  )
}
//addSbtPlugin("io.github.kiemlicz" % "kraftsman" % "0.0.1-1-3363560-dirty-SNAPSHOT")
