package concotra.testutil

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.ChromeDriver

object Driver {
  private var driver : WebDriver = null
  
  def get() = {
    if (driver == null) driver = new ChromeDriver
    driver
  }
  
  def close() { 
    driver.close() 
    driver = null
  }
}
