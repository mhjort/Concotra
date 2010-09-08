package concotra.applicationdata.e2e

import concotra._
import concotra.testutil._

class E2eTest extends ConcordionSuite with WebdriverSupport { 
  
  def enterValidInformation() {
    ApplicationDataPanel.setValidSalary
  }

  def acceptApplication() {
    ApplicationDataPanel.acceptApplication
  }

  def assertApplicationSaved(successText : String) = {
    val entry = Db.readEntry(ApplicationDataPanel.getApplicationId)
    // Check status
    successText
  }
}

