package concotra.applicationdata.ui

import concotra._
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.By

class UiTest extends ConcordionSuite {
  def doTheTrick(successText:String):String = {
    var driver = new FirefoxDriver
    try {
      driver.get("http://localhost:8080")
      Thread.sleep(200)
      var element = driver.findElement(By.id("salary"))
      element.getText
    } finally {
      driver.quit
    }
 }
}

