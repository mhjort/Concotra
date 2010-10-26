#          Copyright (c) 2009 Michael Fellinger m.fellinger@gmail.com
# All files in this distribution are subject to the terms of the Ruby license.

require File.expand_path('../../../../lib/ramaze/spec/helper/snippets', __FILE__)

describe "Numeric#filesize_format" do
  it 'it should convert filesizes to human readable format' do
    1.filesize_format.should == '1'
    1024.filesize_format.should == '1.0K'
    (1 << 20).filesize_format.should == '1.0M'
    (1 << 20).filesize_format.should == '1.0M'
    (1 << 30).filesize_format.should == '1.0G'
    (1 << 40).filesize_format.should == '1.0T'
  end
end
