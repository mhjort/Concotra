package concotra.testutil

import dispatch._
import Http._
import net.liftweb.json.JsonParser._

case class ApplicationData(status: String) {
  def accepted = status == "1"
}

case class Application(salary: String,
                       firstEmploymentStartDate: String, 
                       applicationReceivedDate: String, 
                       unpromptedPayer: String, 
                       declarationMethod: String) {
  def accept = {
    implicit val formats = net.liftweb.json.DefaultFormats
    val response = post(Map("salary" -> salary, 
			    "firstEmploymentStartDate" -> firstEmploymentStartDate,
                            "applicationReceivedDate" -> applicationReceivedDate,
                            "unpromptedPayer" -> unpromptedPayer,
                            "declarationMethod" -> declarationMethod))
    parse(response).extract[ApplicationData]
  }
  
  def post(params : Map[String, String]) = {
    val http = new Http
    val req = new Request("http://localhost:8080")
    val rform = req << params
    http(rform / "api" >~ { _.mkString })
  }
}
