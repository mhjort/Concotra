@echo off
jruby\bin\jruby -S cucumber --color %1 | wac
