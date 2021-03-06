package concotra.testutil

import org.openqa.selenium.{By,WebDriver}
import org.openqa.selenium.support.ui.{WebDriverWait, ExpectedCondition}

class ElementExistsCondition(id : String) extends ExpectedCondition[Boolean] {
  override def apply(driver : WebDriver) = !Driver.get().findElements(By.id(id)).isEmpty
}

object ApplicationDataPanel {
  def setValidSalary() { setSalary("9500") }
  def setSalary(salary : String) { findElement("salary").sendKeys(salary) }
  def setFirstEmploymentStartDate(date : String) { findElement("firstEmploymentStartDate").sendKeys(date) }
  def acceptApplication() {
    findElement("submit").click
    waitElementToAppear("savedApplicationId")
  }
  def getApplicationId = findElement("savedApplicationId").getText
  def findElement(id : String) = Driver.get().findElement(By.id(id))
  def waitElementToAppear(id : String) { new WebDriverWait(Driver.get(), 5).until(new ElementExistsCondition(id)) }
}
