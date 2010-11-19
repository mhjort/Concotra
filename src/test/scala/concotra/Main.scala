package concotra

import org.mortbay.jetty.Server
import org.mortbay.jetty.webapp.WebAppContext

object Main extends Application {
  val server = new Server(8080)
  val context = new WebAppContext()
  context.setDescriptor("webapp/WEB-INF/web.xml")
  context.setResourceBase("webapp")
  context.setContextPath("/")
  context.setParentLoaderPriority(true)
  server.setHandler(context)
  server.start()
  server.join()
}
