package concotra
 
import org.scalatra._
import net.liftweb.json.JsonDSL._
import net.liftweb.json._
 
class ConcotraServlet extends ScalatraServlet with UrlSupport {
 
 before {
   contentType = "application/json"
 }
 
 get("/api") {
   compact(JsonAST.render(("name" -> "Tiina")))
 }
 
 post("/api") {
   Console.println(params("salary"))
   compact(JsonAST.render(("status" -> "1")))
 }
 
 protected def contextPath = request.getContextPath
}
