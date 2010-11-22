@echo off
jruby\bin\jruby -S cucumber --color %* | wac
