#!/bin/bash

rm -rf target/dist
mkdir target/dist/lib/concotra -p
sbt assembly

cp target/concotra.jar target/dist
cp -R src/main/webapp target/dist
cp start* target/dist

cp -R jruby target/dist
cp cuke* target/dist
cp wac.exe target/dist
cp -R features-for-workshop target/dist/features
echo "Created dist to target/dist. You can test it by running ./start"
