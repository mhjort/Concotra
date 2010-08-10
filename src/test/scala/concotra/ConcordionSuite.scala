package concotra

import org.scalatest._
import org.concordion.internal._
import org.scalatest.events._

abstract class ConcordionSuite extends Suite {

  override def tags: Map[String, Set[String]] = Map()

  override def testNames(): Set[String] = Set(this.getClass.getName())

  override def expectedTestCount(filter: Filter) = 1

  protected override def runTest(testName: String, report: Reporter, stopper: Stopper, configMap: Map[String, Any], tracker: Tracker) {
    report(TestStarting(tracker.nextOrdinal(), testName, Some(testName), testName))
    try {
      runConcordionSpec()
    } catch {
      case e: AssertionError => {
        report(TestFailed(tracker.nextOrdinal(), e.getMessage, testName, Some(testName), testName, Some(e)))
        return
      }
    }
    report(TestSucceeded(tracker.nextOrdinal(), testName, Some(testName), testName))
  }
  
  private def runConcordionSpec() {
    val concordionBuilder = new ConcordionBuilder()
    val resultSummary = concordionBuilder.build().process(this);
    resultSummary.print(System.out, this);
    resultSummary.assertIsSatisfied(this);
  }
}

