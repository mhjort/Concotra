package concotra

//import org.concordion.integration.junit4.ConcordionRunner
//import org.junit.runner.RunWith
import org.scalatest._
import org.concordion.internal._

// @RunWith(classOf[ConcordionRunner])
class ExampleTest extends Suite { 
  def getGreeting() : String = {
	  "Hello Markustiina!"
  }
	
  override def testNames: Set[String] = Set("ExampleTest")
  
  protected override def runTest(testName: String, reporter: Reporter, stopper: Stopper, configMap: Map[String, Any], tracker: Tracker) {
    Console.println(testName)
    // super.runTest(testName, reporter, stopper, configMap, tracker)
  }
  
  protected override def runTests(testName: Option[String], reporter: Reporter, stopper: Stopper, filter: Filter,
      configMap: Map[String, Any], distributor: Option[Distributor], tracker: Tracker) {
    Console.println("Running Concordion test")
    val concordionBuilder = new ConcordionBuilder()
    val resultSummary = concordionBuilder.build().process(this);
        resultSummary.print(System.out, this);
        resultSummary.assertIsSatisfied(this);
   //new org.concordion.internal.FixtureRunner().run(this)
  }
}

