package concotra.applicationdata

import concotra._
import concotra.testutil._

class ApplicationdataTest extends ConcordionSuite { 
  def createApplication(salary: String, 
                        firstEmploymentStartDate: String, 
                        applicationReceivedDate: String, 
                        unpromptedPayer: String, 
                        declarationMethod: String) = {
    new Application(salary, firstEmploymentStartDate, applicationReceivedDate, unpromptedPayer, declarationMethod).accept.status
  }
}

