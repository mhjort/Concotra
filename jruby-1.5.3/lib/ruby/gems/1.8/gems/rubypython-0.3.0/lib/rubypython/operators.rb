module RubyPython
  #A mixin module to provide method delegation to a proxy class. This is done
  #either by delegating to methods defined on the wrapped object or by using the
  #Python _operator_ module. A large number of the methods are dynamically
  #generated and so their documentation is not provided here. In general all
  #operators that can be overloaded are delegated.
  module Operators
    #Provides access to the Python _operator_ module.
    #@return[RubyPython::RubyPyModule]
    def self.operator_
      @@operator ||= RubyPython.import('operator')
    end

    #Creates a method to delegate a binary operation. The result of the
    #operation will follow the conversion rules appropriate to the current mode
    #of operation as set by {RubyPython.legacy_mode}.
    #@param[Symbol, String] rname The name of the Ruby method for this operation
    #@param[String] pname The name of the Python magic method to which this
    #method should be delegated.
    def self.bin_op rname, pname
      define_method rname.to_sym do |other|
        self.__send__ pname, other
      end
    end

    #Creates a method to delegate a relational operator. The result of the
    #delegated method will always be converted to a Ruby type so that simple
    #boolean testing may occur. These methods are implemented with calls the
    #_operator_ module.
    #@param[Symbol, String] rname The name of the Ruby method for this operation
    #@param[String] pname The name of the Python magic method to which this
    #method should be delegated.
    def self.rel_op rname, pname
      define_method rname.to_sym do |other|
        Operators.operator_.__send__(pname, self, other).rubify
      end
    end

    #Creates a method to delegate a relational operator. The result of the
    #operation will follow the conversion rules appropriate to the current mode
    #of operation as set by {RubyPython.legacy_mode}. These methods are
    #implemented with calls the _operator_ module.
    #@param[Symbol, String] rname The name of the Ruby method for this operation
    #@param[String] pname The name of the Python magic method to which this
    #method should be delegated.
    def self.unary_op rname, pname
      define_method rname.to_sym do 
        Operators.operator_.__send__(pname, self)
      end
    end


    [
      [:+, '__add__'],
      [:-, '__sub__'],
      [:*, '__mul__'],
      [:/, '__div__'],
      [:&, '__and__'],
      [:^, '__xor__'],
      [:%, '__mod__'],
      [:**, '__pow__'],
      [:>>, '__rshift__'],
      [:<<, '__lshift__'],
      [:|, '__or__']
    ].each do |args|
      bin_op *args
    end

    [
      [:~, :__invert__],
      [:+@, :__pos__],
      [:-@, :__neg__]
    ].each do |args|
      unary_op *args
    end

    [
      [:==, 'eq'],
      [:<, 'lt'],
      [:<=, 'le'],
      [:>, 'gt'],
      [:>=, 'ge'],
      [:equal?, 'is_']
    ].each do |args|
      rel_op *args
    end

    alias :eql? :==

    #Delegates object indexed access to the wrapped Python object.
    def [](index)
      self.__getitem__ index
    end

    #Delegates setting of various indices to the wrapped Python object.
    def []=(index, value)
      self.__setitem__ index, value
    end

    #Delegates membership testing to Python.
    def include?(item)
      self.__contains__(item).rubify
    end

    #Delegates Comparison to Python.
    def <=>(other)
      PyMain.cmp(self, other)
    end

  end
end
