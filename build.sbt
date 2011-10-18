name := "concotra"                                                                                                                                                                                                                                                           
                                                                                                                                                                                                                                                                               
version := "1.0"                                                                                                                                                                                                                                                               
                                                                                                                                                                                                                                                                               
scalaVersion :="2.8.0"                                                                                                                                                                                                                                                      
                                                                                                                                                                                                                                                                               
seq(webSettings :_*)                                                                                                                                                                                                                                                           

resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots"

resolvers += "Sonatype Nexus Releases" at "https://oss.sonatype.org/content/repositories/releases"
                                                                                                                                                                                                                                                                               
libraryDependencies ++= Seq(                                                                                                                                                                                                                                                   
    "net.liftweb" % "lift-json_2.8.0" % "2.1-M1",
     "org.scalatra" %% "scalatra" % "2.0.0-SNAPSHOT",
    "joda-time" % "joda-time" % "1.6.1",
    "org.mortbay.jetty" % "jetty" % "6.1.22" % "jetty,test",                                                                                                                                                                                                                   
    "org.eclipse.jetty" % "jetty-server" % "7.4.5.v20110725",// % "compile,jetty",                                                                                                                                                                                             
    "org.eclipse.jetty" % "jetty-servlet" % "7.4.5.v20110725",    
    "net.databinder" % "dispatch-http_2.8.0" % "0.7.6",
    "net.databinder" % "dispatch-http-json_2.8.0" % "0.7.6",
    "net.databinder" % "dispatch-json_2.8.0" % "0.7.6",
    "org.scalatest" % "scalatest" % "1.2" % "test",
    "org.concordion" % "concordion" % "1.3.1" % "test",
    "org.seleniumhq.selenium" % "selenium" % "2.0a5" % "test")

