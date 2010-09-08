package concotra.applicationdata.ui

import concotra._
import concotra.testutil._
import org.openqa.selenium.By

class UiTest extends ConcordionSuite with WebdriverSupport {
  def doTheTrick(successText:String):String = {  
    findElement("salary").sendKeys("1000")
    findElement("submit").click
    if (findElement("status").getText.length > 0) return successText
    "Epäonnistui"
  }

  def findElement(id : String) = {
    Driver.get().findElement(By.id(id))  
  }
}

