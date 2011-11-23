package concotra

import org.mortbay.jetty.Server
import org.mortbay.jetty.webapp.WebAppContext

object Main  {
  def main(args:Array[String]) = {
    val port = Integer.parseInt(args(0))
    val resourcePath = args(1)
    val server = new Server(port)
    val context = new WebAppContext()
    context.setDescriptor(resourcePath + "/WEB-INF/web.xml")
    context.setResourceBase(resourcePath)
    context.setContextPath("/")
    server.setHandler(context)
    server.start()
    server.join()
  }
}
