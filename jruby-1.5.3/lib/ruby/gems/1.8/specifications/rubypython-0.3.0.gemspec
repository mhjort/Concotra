# -*- encoding: utf-8 -*-

Gem::Specification.new do |s|
  s.name = %q{rubypython}
  s.version = "0.3.0"

  s.required_rubygems_version = Gem::Requirement.new(">= 0") if s.respond_to? :required_rubygems_version=
  s.authors = ["Zach Raines"]
  s.cert_chain = ["-----BEGIN CERTIFICATE-----\nMIIDSDCCAjCgAwIBAgIBADANBgkqhkiG9w0BAQUFADBKMRwwGgYDVQQDDBNyYWlu\nZXN6bV9ydWJ5cHl0aG9uMRUwEwYKCZImiZPyLGQBGRYFZ21haWwxEzARBgoJkiaJ\nk/IsZAEZFgNjb20wHhcNMTAwODA4MDI0NTMwWhcNMTEwODA4MDI0NTMwWjBKMRww\nGgYDVQQDDBNyYWluZXN6bV9ydWJ5cHl0aG9uMRUwEwYKCZImiZPyLGQBGRYFZ21h\naWwxEzARBgoJkiaJk/IsZAEZFgNjb20wggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAw\nggEKAoIBAQDPSmmxYqWWN53XrD4btZ08twipRz5priTFtwmKL01WfhHa66OhDoV2\nOPtW0RoWegZ5gti/gJ67P6IVl1yBekfV581yHsZqV7VqcOkDbT93F3HuTLH12d1C\nw/OhHoGZUURedNeSMjKmMSlCCD4rzCfXTeAEU6E3rXh3u2AD7kQfeYcZA/u0YgrD\nlS3c2oX3GvJHjd4hV5hIGgOGXDxcgH5S1iO6588SBxLN+xdYC82w09e5r09tBvo3\nBXZlsErwuWRI8Ha7y6thbrB28GS5jI378ew4kSUS/1T9Sz4EcPmhyhyCeXvvsdCm\n4BvNPMBl/yP2fhcubMD/Q0t9Ia9chVc3AgMBAAGjOTA3MAkGA1UdEwQCMAAwHQYD\nVR0OBBYEFNLncU/Kj1RRsjb5blAhik0hgvKCMAsGA1UdDwQEAwIEsDANBgkqhkiG\n9w0BAQUFAAOCAQEAj8z1kRS/1sHU2yRZothKrgsOLoDxF1+uYq909rS2d6FqOJbt\nV08JaOil/eMlTjPk7nBUU9OZlNmb8oD0Wt2Lgv9GFMJJm0mch767Nk3h1t9qiJJC\nv4Ida7e6+ArAcHExQx/lul2jJCWezgIVxz9T9unOfvylOyXwAHV4EEK47EeU1TZV\nT4cMl2JyytBtjCPydVJGfirxlM7aTMOZ6FvUbCiFvHaymAgoOVZmm7NpE6GsMT7g\n1b1UcQqvLqyp9gdB3jVeb7JnTLY+WlHWt2rFVbeqv7KtJlp7+4uWMKkzTbW/ujdG\ncguJMiQCSOlUPZxCWWMkjfZbXvtS5VdzJevSqQ==\n-----END CERTIFICATE-----\n"]
  s.date = %q{2010-09-23}
  s.description = %q{A bridge between ruby and python}
  s.email = ["raineszm+rubypython@gmail.com"]
  s.extra_rdoc_files = ["License.txt", "Manifest.txt", "PostInstall.txt", "History.markdown"]
  s.files = ["History.markdown", "License.txt", "Manifest.txt", "PostInstall.txt", "README.markdown", "Rakefile", "lib/rubypython.rb", "lib/rubypython/blankobject.rb", "lib/rubypython/core_ext/string.rb", "lib/rubypython/pythonerror.rb", "lib/rubypython/macros.rb", "lib/rubypython/conversion.rb", "lib/rubypython/operators.rb", "lib/rubypython/pyobject.rb", "lib/rubypython/pymainclass.rb", "lib/rubypython/python.rb", "lib/rubypython/rubypyproxy.rb", "lib/rubypython/version.rb", "lib/rubypython/legacy.rb", "spec/pymainclass_spec.rb", "spec/pyobject_spec.rb", "spec/python_helpers/objects.py", "spec/pythonerror_spec.rb", "spec/rubypyclass_spec.rb", "spec/rubypyproxy_spec.rb", "spec/rubypython_spec.rb", "spec/refcnt_spec.rb", "spec/conversion_spec.rb", "spec/legacy_spec.rb", "spec/spec.opts", "spec/spec_helper.rb"]
  s.homepage = %q{http://bitbucket.org/raineszm/rubypython/}
  s.post_install_message = %q{A number of things have changed with version 0.3.0. If you are upgrading from a previous version of RubyPython, you should check the docs for instructions on how to get your code working with the new version of RubyPython.

For more information on RubyPython, see http://raineszm.bitbucket.org/rubypython/index.html

If you find a bug, or have any suggestions, email me at: raineszm+rubypython@gmail.com

If you would like to help develop RubyPython, also send me an email.


}
  s.rdoc_options = ["--markup", "markdown", "--title", "RubyPython Documentation", "--quiet"]
  s.require_paths = ["lib"]
  s.requirements = ["Python, ~>2.4"]
  s.rubyforge_project = %q{rubypython}
  s.rubygems_version = %q{1.3.6}
  s.summary = %q{A bridge between ruby and python}

  if s.respond_to? :specification_version then
    current_version = Gem::Specification::CURRENT_SPECIFICATION_VERSION
    s.specification_version = 3

    if Gem::Version.new(Gem::RubyGemsVersion) >= Gem::Version.new('1.2.0') then
      s.add_runtime_dependency(%q<ffi>, [">= 0.6.3"])
      s.add_runtime_dependency(%q<blankslate>, [">= 2.1.2.3"])
    else
      s.add_dependency(%q<ffi>, [">= 0.6.3"])
      s.add_dependency(%q<blankslate>, [">= 2.1.2.3"])
    end
  else
    s.add_dependency(%q<ffi>, [">= 0.6.3"])
    s.add_dependency(%q<blankslate>, [">= 2.1.2.3"])
  end
end
