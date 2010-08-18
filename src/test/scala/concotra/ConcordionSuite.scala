package concotra

import java.io.{PrintStream, OutputStream}
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
      runConcordionSpec(tracker, report)
    } catch {
      case e: AssertionError => {
        report(TestFailed(tracker.nextOrdinal(), e.getMessage, testName, Some(testName), testName, Some(e)))
        return
      }
    }
    report(TestSucceeded(tracker.nextOrdinal(), testName, Some(testName), testName))
  }
  
  private def runConcordionSpec(tracker : Tracker, report : Reporter) {
    val resultSummary = new ConcordionBuilder().build().process(this);
    resultSummary.print(new ReportStream(tracker, report), this);
    resultSummary.assertIsSatisfied(this);
  }
  
  class ReportStream(tracker : Tracker, report : Reporter) extends PrintStream(new DevNullOutputStream) {
	  override def print(s : String) = report(InfoProvided(tracker.nextOrdinal(), s, None, None, None))
	  override def println(s: String) = report(InfoProvided(tracker.nextOrdinal(), s, None, None, None))
  }
  
  class DevNullOutputStream extends OutputStream {
	  override def write(byte : Int) = {}
  }
}