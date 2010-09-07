package concotra.applicationdata

import concotra._
import dispatch._
import Http._
import net.liftweb.json.JsonParser._

case class Person(age: String)

class ApplicationdataTest extends ConcordionSuite { 
  implicit val formats = net.liftweb.json.DefaultFormats

  def doTheTrick(age : String) = {
    val response = post(Map("age" -> age))
    val person = parse(response).extract[Person]
    Console.println(person)
  }

  def post(params : Map[String, String]) = {
    val http = new Http
    val req = new Request("http://localhost:8080")
    val rform = req << params
    http(rform / "api" >~ { _.mkString })
  }
}

