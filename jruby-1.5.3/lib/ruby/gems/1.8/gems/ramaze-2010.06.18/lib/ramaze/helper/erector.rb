#          Copyright (c) 2008 Michael Fellinger m.fellinger@gmail.com
# All files in this distribution are subject to the terms of the Ruby license.

require 'erector'

module Ramaze

  # Allows you to use some shortcuts for Erector in your Controller.

  # use this inside your controller to directly build Erector 
  # Refer to the Erector-documentation and testsuite for more examples.
  # Usage:
  #   erector { h1 "Apples & Oranges" }                           #=> "<h1>Apples &amp; Oranges</h1>"
  #   erector { h1(:class => 'fruits&floots'){ text 'Apples' } }  #=> "<h1 class=\"fruits&amp;floots\">Apples</h1>"

  module Helper
    module Erector
      include ::Erector::Mixin

      class ::Erector::Widget
        alias :raw! :rawtext
        alias :old_css :css

        def strict_xhtml(*args, &block)
          raw! '<?xml version="1.0" encoding="UTF-8"?>'
          raw! '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "DTD/xhtml1-strict.dtd">'
          html(:xmlns => "http://www.w3.org/1999/xhtml", :"xml:lang" => "en", :lang => "en", &block)
        end

        def js(src)
          script :src => src
        end

        def ie_if(expr, &block)
          raw! "<!--[if #{expr}]>"
          yield
          raw! "<![endif]-->"
        end

        # Diagnostics
        def inspect(elem)
          text elem.inspect
        end

        def css(href, args = {})
          attrs = {
            :rel => "stylesheet", 
            :href => href, 
            :type => "text/css" 
          }.merge(args)

          link attrs
        end
      end
    end
  end
end

