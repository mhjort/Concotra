import sbt._
import Process._
import de.element34.sbteclipsify._

class ConcotraProject(info: ProjectInfo) extends DefaultWebProject(info) with Eclipsify
{
  // For Scalatra snapshots
  val sonatypeNexusSnapshots = "Sonatype Nexus Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  val sonatypeNexusReleases = "Sonatype Nexus Releases" at "https://oss.sonatype.org/content/repositories/releases"
  		
  // Main dependencies
  val scalatra = "org.scalatra" %% "scalatra" % "2.0.0-SNAPSHOT"
  val lift_json = "net.liftweb" % "lift-json_2.8.0" % "2.1-M1"
  val dispatch_http = "net.databinder" % "dispatch-http_2.8.0" % "0.7.6"
  val dispatch_http_json = "net.databinder" % "dispatch-http-json_2.8.0" % "0.7.6"
  val dispatch_json = "net.databinder" % "dispatch-json_2.8.0" % "0.7.6"

  // Test dependencies
  val scalatest = "org.scalatest" % "scalatest" % "1.2" % "test"
  val jetty6 = "org.mortbay.jetty" % "jetty" % "6.1.22" % "test"
  val servletApi = "org.mortbay.jetty" % "servlet-api" % "2.5-20081211" % "provided"
  val concordion = "org.concordion" % "concordion" % "1.3.1" % "test"
  val webdriver = "org.seleniumhq.selenium" % "selenium" % "2.0a4" % "test"
}

