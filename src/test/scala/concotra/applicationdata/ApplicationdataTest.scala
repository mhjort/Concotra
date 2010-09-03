package concotra.applicationdata

import concotra._
import dispatch._
import Http._
import dispatch.json.JsHttp._

class ApplicationdataTest extends ConcordionSuite { 
  def doTheTrick() = {
    val http = new Http
    
    val req = new Request("http://localhost:8080")
    val rform = req << Map("age" -> "31")
    val age = http(rform / "api" ># { 'age ! str })
     Console.println(age)
  }
}

