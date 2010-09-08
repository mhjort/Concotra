package concotra.applicationdata.e2e

import concotra._
import concotra.testutil._
import org.openqa.selenium.By

class E2eTest extends ConcordionSuite with WebdriverSupport { 
  
  def enterValidInformation() {
    findElement("salary").sendKeys("1000")
  }

  def acceptApplication() {
    findElement("submit").click
  }

  def assertApplicationSaved(successText : String) = {
    val db = new Db
    val id = findElement("savedApplicationId").getText
    val entry = db.readEntry(id)
    // Check status
    successText
  }

  def findElement(id : String) = {
    Driver.get().findElement(By.id(id))  
  }
}

