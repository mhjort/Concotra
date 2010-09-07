package concotra.applicationdata

import concotra._
import dispatch._
import Http._
import net.liftweb.json.JsonParser._

case class ApplicationData(status: String)

class ApplicationdataTest extends ConcordionSuite { 
  implicit val formats = net.liftweb.json.DefaultFormats

  def createApplication(salary : String, firstEmploymentStartDate:String) = {
    val response = post(Map("salary" -> salary, "firstEmploymentStartDate" -> firstEmploymentStartDate))
    parse(response).extract[ApplicationData].status
  }
  
  def post(params : Map[String, String]) = {
    val http = new Http
    val req = new Request("http://localhost:8080")
    val rform = req << params
    http(rform / "api" >~ { _.mkString })
  }
}

