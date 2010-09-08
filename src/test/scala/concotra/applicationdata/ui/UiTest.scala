package concotra.applicationdata.ui

import concotra._
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.By

class UiTest extends ConcordionSuite {
  private val driver = new FirefoxDriver

  def doTheTrick(successText:String):String = {  
    try {
      driver.get("http://localhost:8080")
      findElement("salary").sendKeys("1000")
      findElement("submit").click
      if (findElement("status").getText.length > 0) return successText
      "Epäonnistui"
    } finally {
      driver.quit
    }
  }

  def findElement(id : String) = {
      driver.findElement(By.id(id))  
  }
}

