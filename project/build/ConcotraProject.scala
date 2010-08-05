import sbt._
import Process._
import de.element34.sbteclipsify._

class ConcotraProject(info: ProjectInfo) extends DefaultWebProject(info) with Eclipsify
{
  // scalatra
  val sonatypeNexusSnapshots = "Sonatype Nexus Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  val sonatypeNexusReleases = "Sonatype Nexus Releases" at "https://oss.sonatype.org/content/repositories/releases"
  val scalatra = "org.scalatra" %% "scalatra" % "2.0.0-SNAPSHOT"
 
  // jetty
  val jetty6 = "org.mortbay.jetty" % "jetty" % "6.1.22" % "test"
  val servletApi = "org.mortbay.jetty" % "servlet-api" % "2.5-20081211" % "provided"

  val concordion = "org.concordion" % "concordion" % "1.3.1" % "test"

  val bryanjswift = "Bryan J Swift Repository" at "http://repos.bryanjswift.com/maven2/" 
  val junitInterface = "com.novocode" % "junit-interface" % "0.4.0" % "test"
 
  lazy val specs = execTask { "java -cp project/boot/scala-2.8.0/lib/scala-library.jar:" + testClasspath.absString + " org.junit.runner.JUnitCore concotra.AllSpecs" } dependsOn(compile, test)
  //lazy val specs = execTask { "java " + testClasspath.absString ! }

  //override def testFrameworks = super.testFrameworks ++ List(new TestFramework("com.novocode.junit.JUnitFrameworkNoMarker")) 
}
