require "selenium-webdriver"

Given /^the application data form is opened$/ do

  driver = Selenium::WebDriver.for :firefox
  driver.navigate.to "http://localhost:8080"

  puts driver.title

  driver.quit                                                                                                                                               
end                                                                                                                                                                                            
                                                                                                                                                                                               
When /^application handler enters following information$/ do |table|                                                                                                                           
  # table is a Cucumber::Ast::Table                                                                                                                                                            
  pending # express the regexp above with the code you wish you had                                                                                                                            
end                                                                                                                                                                                            
                                                                                                                                                                                               
Then /^incomplete application is created$/ do                                                                                                                                                  
  pending # express the regexp above with the code you wish you had                                                                                                                            
end      
