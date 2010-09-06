package concotra.applicationdata

import concotra._
import dispatch._
import Http._
import dispatch.json.JsHttp._
import net.liftweb.json.JsonParser._

  case class Person(age: String)
class ApplicationdataTest extends ConcordionSuite { 
  implicit val formats = net.liftweb.json.DefaultFormats
  def doTheTrick() = {
    val http = new Http
    
    val req = new Request("http://localhost:8080")
    val rform = req << Map("age" -> "31")
    val response = http(rform / "api" >~ { _.mkString })
    val person = parse(response).extract[Person]
    Console.println(person)
  }
}

