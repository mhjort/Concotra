Feature: Application data 

Scenario: End to end basic case
Given the application data form is opened
When the insurance clerk enters following information
	|Salary|First employment start date|Application arrival date|Declaration method|
	|9500  |1.1.2010		   |1.5.2010		    |MONTHLY	       |  
And submits the form
Then incomplete application is created

Scenario: If data is in wrong format, format error is shown
Given the application data form is opened
And insurance clerk has entered valid data to form
When she gives 'text' to salary field
And submits the form 
Then format error message is shown

Scenario Outline: Earliest possible first employment start date is 1.1.1961
Given the insurance clerk has given valid data
When she gives <First employment start date> as first employment start date
And accepts the data
Then the result is <Result>

Examples:
	|First employment start date|Result|
	|15.9.2009|OK|
	|1.1.1961|OK|
	|31.12.1960|BUSINESS_RULE_VIOLATED|

Scenario Outline: Salary has to be positive number
Given the insurance clerk has given valid data
When she gives <Salary> as salary
And accepts the data	
Then the result is <Result>

Examples:
	|Salary		|Result	|
	|9500 		|OK	|
	|0		|OK	|
	|-1000		|BUSINESS_RULE_VIOLATED|
	|2345.60	|OK	|
