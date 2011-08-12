require "selenium-webdriver"

After do |s| 
  if !@driver.nil? then @driver.quit end 
end

Given /^the application is opened$/ do
  @driver = Selenium::WebDriver.for :firefox
  @driver.navigate.to @host
end                                                                                                                                                                                            
Given /^the employer has entered valid data to form$/ do  
  enter_valid_data
end

When /^the employer gives company's information$/ do
  enter_valid_data
end 

When /^she enters '(.*)' to salary field$/ do |input|
  enter_value('salary', input)
end

When /^applies insurance$/ do
  submit_form
end 

When /^submits the form$/ do
  submit_form
end  

Then /^incomplete application is created$/ do
  id = find_by_id('savedApplicationId').text
  saved_status = read_db_entry(id)["status"]
  saved_status.should == "1"
end  

Then /^reference number is shown to employer$/ do                                                                                      reference_number = get_application_id
  reference_number.should_not be_empty
end  

Then /^business rule violation error message is shown$/ do                                                                                                                        
  message = find_by_id("status").find_elements(:class, "business_rule_violated")  
  message.should_not be_empty                                                                                                            
end

Then /^format error message is shown$/ do                                                                                                 message = find_by_id("status").find_elements(:class, "format_error")  
  message.should_not be_empty
end  

def enter_valid_data()
  enter_value('salary', '9500')
  enter_value('firstEmploymentStartDate', '1.1.2010') 
  find_by_id('monthly').click
end

def submit_form()
  find_by_id('submit').click
  sleep(1)
end

def read_db_entry(id) 
  entry = IO.read("db/" + id)
  JSON.parse(entry)
end

def get_application_id()
  reference_number = find_by_id("savedApplicationId").text
end

def find_by_id(id)
  @driver.find_element(:id, id) 
end   

def enter_value(id, value)
  field = find_by_id(id)
  field.clear
  field.send_keys value
end 
