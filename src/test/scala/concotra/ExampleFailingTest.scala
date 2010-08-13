package concotra

import org.concordion.api.ExpectedToFail

@ExpectedToFail
class ExampleFailingTest extends ConcordionSuite { 
  def getGreeting() : String = {
	  "Failing"
  }
}

