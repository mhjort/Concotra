Feature: Format rules

Scenario Outline: Date format is d.m.yyyy
Given the insurance clerk has given valid data
When she gives <Date> as first employment start date
And accepts the data
Then the result is <Result>

Examples:
        |Date|Result|
        |15.9.2009|OK|
        |15.09.2009|OK|
        |15092009|FORMAT_ERROR|
	|text|FORMAT_ERROR|
	|15/09/2009|FORMAT_ERROR|

