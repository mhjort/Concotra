require "json"
require "rest_client"

def rest_post(data)
  RestClient.post 'http://localhost:8080/api', data
end

# Step 1
#Given /^the employer has given valid data$/ do
#  @valid_data = { :declarationMethod => 'MONTHLY', :salary => '9600', :firstEmploymentStartDate => '1.2.2010' }
#end 

# Step 2
#When /^she gives (.*) as first employment start date$/ do |first_employment_start_date|
#pending
#end

When /^accepts the data$/ do
  # Step 3
  # In here we have to post data using Rest and save the result to @response variable
  pending
end                                                                                                                                                                                

Then /^the result is (.*)$/ do |expected_response_status|
  actual_response_status = JSON.parse(@response)["status"]
  # Step 4
  # Expectation here
end

# Step 4
# Salary case (First modify the feature file and change @ignore to @api in Salary scenario

# Ruby hash  & symbols tutorial

# Creating: hash = { :symbol => 'VALUE', :symbol2 => 1 }
# Updating: hash[:symbol] = 'NEW_VALUE'


# Expectations tutorial

# actual.should == expected
# actual.should_not == expected
# actual.should eq(expected)
# actual.should_not eq(expected)