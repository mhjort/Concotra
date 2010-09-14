package concotra.testutil

import org.scalatest.{BeforeAndAfterEach,Suite}

trait WebdriverSupport extends BeforeAndAfterEach {
  this: Suite => 
  
  override def beforeEach() {
    Driver.get().get("http://localhost:8080")
  }

  override def afterEach() {
    Driver.close()
  }
}
