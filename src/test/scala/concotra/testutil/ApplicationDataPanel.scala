package concotra.testutil

import org.openqa.selenium.By

object ApplicationDataPanel {

  def setValidSalary() {setSalary("9500")}

  def setSalary(salary : String) {findElement("salary").sendKeys(salary)}

  def acceptApplication() {
    findElement("submit").click
    Thread.sleep(100)
  }

  def getApplicationId = findElement("savedApplicationId").getText

  def findElement(id : String) = {
    Driver.get().findElement(By.id(id))  
  }
}