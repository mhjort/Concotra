#!/bin/bash

#NOTE! Remember first run sbt test-compile package

rm -rf target/dist
mkdir target/dist/lib/concotra -p

cp -R target/scala_2.8.0/webapp target/dist
cp -R lib_managed/scala_2.8.0/test/jetty*.jar target/dist/lib
cp -R lib_managed/scala_2.8.0/provided/servlet*.jar target/dist/lib
cp target/scala_2.8.0/test-classes/concotra/Main*.class target/dist/lib/concotra
cp start target/dist

