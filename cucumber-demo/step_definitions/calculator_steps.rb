#Before do 
#  @calculator = Calculator.new
#end

#Given /^I have entered (\d+) into the calculator$/ do |value|
#  @calculator.push value.to_i
#end

#When /^I press add$/ do
#  @calculator.add
#end

#Then /^the result should be (\d+) on the screen$/ do |expected_result|
#  @calculator.result.should == expected_result.to_i
#end


################################
#### Implementation ############
################################
class Calculator
  attr_accessor :result
  
  def initialize
    @values = []
    @result = 0
  end
  
  def push(value) 
    @values.push value
  end
  
  def add
    @values.each { |i| @result += i }
  end
end
