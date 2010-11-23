package concotra
 
import org.scalatra._
import net.liftweb.json.JsonDSL._
import net.liftweb.json._
import org.joda.time.format.DateTimeFormat
import java.text.{DecimalFormat,ParseException}

class ConcotraServlet extends ScalatraServlet with UrlSupport {
  before {
    contentType = "application/json"
  }
 
  post("/api") { 
    try {
      val firstEmploymentStartDate = toDate(params("firstEmploymentStartDate"))
      val salary = toMoney(params("salary"))
      if (firstEmploymentStartDate.isBefore(toDate("1.1.1961")) || salary < 0) 
        compact(JsonAST.render(("status" -> "BUSINESS_RULE_VIOLATED")))
      else {
        val id = Db.newEntry(compact(JsonAST.render(
	  ("salary" -> params("salary")) ~ 
	  ("firstEmploymentStartDate" -> params("firstEmploymentStartDate")) ~ 
          ("status" -> "1") ~
          ("declarationMethod" -> params("declarationMethod"))))) 
        compactResponse(id, "OK")
      }
    } catch {
      case _: FormatException => compact(JsonAST.render(("status" -> "FORMAT_ERROR")))
    }
   }

  def compactResponse(id: Int, status: String) = compact(JsonAST.render(("status" -> status) ~ ("id" -> id)))
 
  def toDate(date : String) = {
    try {    
      DateTimeFormat.forPattern("dd.MM.yyyy").parseDateTime(date)
    } catch {
        case _: IllegalArgumentException => throw new FormatException
    }
  }
  
  def toMoney(money : String) = {
    try {    
      new DecimalFormat("0,00").parse(money).doubleValue()
    } catch {
        case _: ParseException => throw new FormatException
    }
  }

  protected def contextPath = request.getContextPath
}

class FormatException extends RuntimeException {}
