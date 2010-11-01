Feature: Application data
  In order 

Scenario: End to end basic case
Given the application data form is opened
When application handler enters following information
	|Salary|First employment start date|Application arrival date|Declaration method|
	|9500  |1.1.2010		   |1.5.2010		    |MONTHLY	       |  
Then incomplete application is created
