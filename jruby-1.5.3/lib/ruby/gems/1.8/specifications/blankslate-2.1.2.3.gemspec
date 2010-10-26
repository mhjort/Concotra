# -*- encoding: utf-8 -*-

Gem::Specification.new do |s|
  s.name = %q{blankslate}
  s.version = "2.1.2.3"

  s.required_rubygems_version = Gem::Requirement.new(">= 0") if s.respond_to? :required_rubygems_version=
  s.authors = ["Jim Weirich", "David Masover", "Jack Danger Canty"]
  s.date = %q{2009-01-03}
  s.email = %q{dave@3mix.com}
  s.files = ["README", "lib/blankslate.rb"]
  s.require_paths = ["lib"]
  s.rubygems_version = %q{1.3.6}
  s.summary = %q{BlankSlate extracted from Builder.}

  if s.respond_to? :specification_version then
    current_version = Gem::Specification::CURRENT_SPECIFICATION_VERSION
    s.specification_version = 3

    if Gem::Version.new(Gem::RubyGemsVersion) >= Gem::Version.new('1.2.0') then
    else
    end
  else
  end
end
