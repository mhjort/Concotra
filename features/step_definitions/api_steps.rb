require "json"
require "rest_client"

Given /^the employer has given valid data$/ do
  @valid_data = { :declarationMethod => 'MONTHLY', :salary => '9600', :firstEmploymentStartDate => '1.2.2010' }
end 

When /^she gives (.*) as first employment start date$/ do |first_employment_start_date|
  @valid_data[:firstEmploymentStartDate] =  first_employment_start_date
end 

When /^she gives (.*) as salary$/ do |salary|
  @valid_data[:salary] = salary
end  

When /^accepts the data$/ do
  @response = RestClient.post 'http://localhost:8080/api', @valid_data
end                                                                                                                                                                                
Then /^the result is (.*)$/ do |expected_response_status|
  response_status = JSON.parse(@response)["status"]
  response_status.should == expected_response_status
end
