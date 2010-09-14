package concotra
 
import org.scalatra._
import net.liftweb.json.JsonDSL._
import net.liftweb.json._
import org.joda.time.format.DateTimeFormat

class ConcotraServlet extends ScalatraServlet with UrlSupport {
  before {
    contentType = "application/json"
  }
 
  get("/api") {
    compact(JsonAST.render(("name" -> "Tiina")))
  }
 
  post("/api") {
    val firstEmploymentStartDate = toDate(params("firstEmploymentStartDate"))
    if (firstEmploymentStartDate.isBefore(toDate("1.1.1961")))
      compactResponse(-1, "0") 
    else {
      val id = Db.newEntry(compact(JsonAST.render(("salary" -> params("salary")))))
      compactResponse(id, "1")
    }
  }

  def compactResponse(id: Int, status: String) = compact(JsonAST.render(("status" -> status) ~ ("id" -> id)))
 
  def toDate(date : String) = DateTimeFormat.forPattern("dd.MM.yyyy").parseDateTime(date)

  protected def contextPath = request.getContextPath
}
