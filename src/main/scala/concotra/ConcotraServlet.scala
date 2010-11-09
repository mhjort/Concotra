package concotra
 
import org.scalatra._
import net.liftweb.json.JsonDSL._
import net.liftweb.json._
import org.joda.time.format.DateTimeFormat

class ConcotraServlet extends ScalatraServlet with UrlSupport {
  before {
    contentType = "application/json"
  }
 
  post("/api") {
    val firstEmploymentStartDate = toDate(params("firstEmploymentStartDate"))
    if (firstEmploymentStartDate.isBefore(toDate("1.1.1961")) || new java.math.BigDecimal(params("salary")).doubleValue() < 0)
      compactResponse(-1, "0") 
    else {
     val status = "1"
     val id = Db.newEntry(compact(JsonAST.render(
	("salary" -> params("salary")) ~ 
	("firstEmploymentStartDate" -> params("firstEmploymentStartDate")) ~ 
        ("status" -> status))))
      compactResponse(id, status)
    }
  }

  def compactResponse(id: Int, status: String) = compact(JsonAST.render(("status" -> status) ~ ("id" -> id)))
 
  def toDate(date : String) = DateTimeFormat.forPattern("dd.MM.yyyy").parseDateTime(date)

  protected def contextPath = request.getContextPath
}
