package concotra.applicationdata

import concotra._
import concotra.testutil._

class FirstEmploymentStartDateTest extends ConcordionSuite { 
  def createApplication(firstEmploymentStartDate: String) = {
    var applicationData = new Application("9500", firstEmploymentStartDate, "1.1.2000", "Kyllä", "Kuukausi-ilmoittaja").accept
    if (applicationData.accepted) "Hakemus luotu" else "Virhe"
  }
}
