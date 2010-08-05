package concotra

import org.concordion.integration.junit4.ConcordionRunner
import org.junit.runner.RunWith

@RunWith(classOf[ConcordionRunner])
class ExampleTest {
	def getGreeting() : String = {
		"Hello Markustiina!"
	}
}

