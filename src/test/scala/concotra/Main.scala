package concotra

import org.mortbay.jetty.Server
import org.mortbay.jetty.webapp.WebAppContext

object Main  {
  def main(args:Array[String]) = {
    val server = new Server(Integer.parseInt(args(0)))
    val context = new WebAppContext()
    context.setDescriptor("webapp/WEB-INF/web.xml")
    context.setResourceBase("webapp")
    context.setContextPath("/")
    context.setParentLoaderPriority(true)
    server.setHandler(context)
    server.start()
    server.join()
  }
}
