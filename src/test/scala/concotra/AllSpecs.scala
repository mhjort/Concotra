package concotra

import org.junit.runners._
import org.junit.runners.Suite._
import org.junit.runner.RunWith

@RunWith(classOf[Suite])
@SuiteClasses(Array(classOf[ExampleTest]))
class AllSpecs {}
