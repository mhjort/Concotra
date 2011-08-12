require "json"
require "rest_client"

Given /^the employer has given valid data$/ do
  @valid_data = { :declarationMethod => 'MONTHLY', :salary => '9600', :firstEmploymentStartDate => '1.2.2010' }
end 

When /^she gives (.*) as first employment start date$/ do |first_employment_start_date|
  @valid_data[:firstEmploymentStartDate] =  first_employment_start_date
  @response = rest_post(@valid_data)
end 

When /^she gives (.*) as salary$/ do |salary|
  @valid_data[:salary] = salary
  @response = rest_post(@valid_data) 
end  

Then /^the result is (.*)$/ do |expected_response_status|
  response_status = JSON.parse(@response)["status"]
  response_status.should == expected_response_status
end

def rest_post(data)
  RestClient.post @api_url, data
end
