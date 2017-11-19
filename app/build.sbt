libraryDependencies  ++= Seq(
  "org.scalanlp" %% "breeze" % "0.13.2",
  "org.apache.commons" % "commons-lang3" % "3.1"
)


resolvers += "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"

libraryDependencies += "net.sourceforge.f2j" % "arpack_combined_all" % "0.1"
libraryDependencies += "com.github.fommil.netlib" % "netlib-native_ref-linux-x86_64" % "1.1" classifier "natives"
libraryDependencies += "com.github.fommil.netlib" % "netlib-native_system-linux-x86_64" % "1.1" classifier "natives"