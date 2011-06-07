require "json"
require "rest_client"

def rest_post(data)
  RestClient.post @api_url, data
end

# Step 1
# Uncomment this method
#Given /^the employer has given valid data$/ do
#  @input = { :declarationMethod => 'MONTHLY', :salary => '9600', :firstEmploymentStartDate => '1.2.2010' }
#end 

# Step 2
# Uncomment this method and fill details
#When /^she gives (.*) as first employment start date$/ do |first_employment_start_date|
#end

When /^accepts the data$/ do
  # Step 3
  # In here we have to post data using Rest and save the result to @response variable
  pending
end                                                                                                                                                                                

Then /^the result is (.*)$/ do |expected_response_status|
  actual_response_status = JSON.parse(@response)["status"]
  # Step 4 (Replace this with proper assertion)
  fail 'Assertion fails'
end

# Step 5
# Implement salary rules (First modify the feature file by adding this) 
#Scenario Outline: Salary has to be positive number
#Given the employer has given valid data
#When she gives <Salary> as salary
#And accepts the data
#Then the result is <Result>
#
#Examples:
#        |Salary         |Result |
#        |9500           |OK     |
#        |0              |OK     |
#        |-1000          |BUSINESS_RULE_VIOLATED|
#        |2345.60        |OK     |


# Ruby tutorial

# Using local variables: variable = value
# Assigning to a field: @variable = value

# Creating: hash = { :symbol => 'VALUE', :symbol2 => 1 }
# Updating: hash[:symbol] = 'NEW_VALUE'

# Expectations tutorial

# actual.should == expected
# actual.should_not == expected
# actual.should eq(expected)
# actual.should_not eq(expected)
