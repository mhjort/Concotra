Feature: Application data

  In order 

Scenario: End to end basic case
Given the application data form is opened
When the insurance clerk enters following information
	|Salary|First employment start date|Application arrival date|Declaration method|
	|9500  |1.1.2010		   |1.5.2010		    |MONTHLY	       |  
Then incomplete application is created

Scenario: Salary - API

Given application handler has given otherwise valid data
When she gives <Salary>	
Then the result is <Result>
	|Salary		|Result	|
	|9500 		|OK	|
	|0		|OK	|
	|-1000		|ERROR	|
	|2345.60	|OK	|
