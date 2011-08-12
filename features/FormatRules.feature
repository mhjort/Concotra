Feature: Format rules

Scenario Outline: Date format is d.m.yyyy
Given the employer has given valid data
When she gives <Date> as first employment start date
Then the result is <Result>

Examples:
        |Date|Result|
        |15.9.2009|OK|
        |15.09.2009|OK|
        |15092009|FORMAT_ERROR|
	|text|FORMAT_ERROR|
	|15/09/2009|FORMAT_ERROR|


Scenario Outline: Money format is NN,NN or NN.NN
Given the employer has given valid data
When she gives <Money> as salary
Then the result is <Result>

Examples:
	|Money|Result|
	|12345,12|OK|
	|12345.12|OK|
	|text|FORMAT_ERROR|
	|12345|OK|
