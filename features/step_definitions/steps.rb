require "selenium-webdriver"
require "json"
require "rest_client"


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

Given /^application handler has given otherwise valid data$/ do                                                                                                                                
  response = RestClient.post 'http://localhost:8080/api', :salary => '9600', :firstEmploymentStartDate => '1.2.2010'                                                                          
  puts response.to_str
end            

                                                                                                                                                                                          
Then /^incomplete application is created$/ do
  id = find_by_id('savedApplicationId').text
  @driver.quit                                                                                                                                               
  saved_status = read_db_entry(id)["status"]
  saved_status.should == "1"
end  

def read_db_entry(id) 
  entry = IO.read("db/" + id)
  JSON.parse(entry)
end

def find_by_id(id)
  @driver.find_element(:id, id) 
end   

def enter_value(id, value)
  find_by_id(id).send_keys value
end 
