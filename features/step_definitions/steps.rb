require "selenium-webdriver"

Given /^the application data form is opened$/ do
  @driver = Selenium::WebDriver.for :firefox
  @driver.navigate.to "http://localhost:8080"
end                                                                                                                                                                                            
When /^application handler enters following information$/ do |values|
  row = values.hashes[0]
  enter_value('salary', row["Salary"])
  enter_value('firstEmploymentStartDate', row["First employment start date"])
  find_by_id('submit').click
  sleep(1)
end                                                                                                                                                                                            
Then /^incomplete application is created$/ do
  puts find_by_id('savedApplicationId').text
  @driver.quit                                                                                                                                               
end  

def find_by_id(id)
  @driver.find_element(:id, id) 
end   

def enter_value(id, value)
  find_by_id(id).send_keys value
end 
