package concotra.testutil

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

object Driver {
  private var driver : WebDriver = null
  
  def get() = {
    if (driver == null) driver = new FirefoxDriver
    driver
  }
  
  def close() { 
    driver.close() 
    driver = null
  }
}