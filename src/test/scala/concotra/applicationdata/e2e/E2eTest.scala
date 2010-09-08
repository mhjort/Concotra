package concotra.applicationdata.e2e

import concotra._
import org.scalatest.BeforeAndAfterEach
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.By

class E2eTest extends ConcordionSuite with BeforeAndAfterEach { 
  private val driver = new FirefoxDriver

  def enterValidInformation() {
    driver.get("http://localhost:8080")
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
    driver.findElement(By.id(id))  
  }

  override def afterEach() {
    driver.quit
  }
}

